package com.t4e1.minihub.command.history.controller;

import com.amazonaws.Response;
import com.t4e1.minihub.command.aws.S3Service;
import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.service.HistoryService;
import com.t4e1.minihub.command.history.vo.ReqVO;
import com.t4e1.minihub.command.history.vo.ResVO;
import com.t4e1.minihub.common.converter.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("HistoryCommandController")
@RequestMapping("/records")
public class HistoryController {

    private final HistoryService historyService;
    private final S3Service s3Service;
    private final VOMapper voMapper;

    @Autowired
    public HistoryController(HistoryService historyService, S3Service s3Service,
                             @Qualifier("VOMapperImpl") VOMapper voMapper) {
        this.historyService = historyService;
        this.s3Service = s3Service;
        this.voMapper = voMapper;
    }

    @PostMapping
    public ResponseEntity<ResVO> addRecord(@RequestBody ReqVO addData){

        HistoryDTO inputData = voMapper.INSTANCE.historyDTO(addData);

        if(historyService.addRecord(inputData)){
            ResVO response = new ResVO("/records/list", inputData);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PostMapping("/images")
    public ResponseEntity<List<String>> addImages(List<MultipartFile> files) {

        List<String> response = s3Service.s3Upload(files);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResVO> modifyRecord(@PathVariable("id") int id,
                                           @RequestBody ReqVO data) {

        HistoryDTO modifyData = voMapper.INSTANCE.historyDTO(data);
        modifyData.setId(id);

        if(historyService.modifyRecord(modifyData)){

            ResVO response = new ResVO("/records/" + id, modifyData);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
