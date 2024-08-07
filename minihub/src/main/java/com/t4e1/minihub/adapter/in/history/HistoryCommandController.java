package com.t4e1.minihub.adapter.in.history;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.command.aws.S3Service;
import com.t4e1.minihub.command.history.service.HistoryService;
import com.t4e1.minihub.adapter.in.history.vo.HistoryReqVO;
import com.t4e1.minihub.adapter.in.history.vo.HistoryResVO;
import com.t4e1.minihub.common.converter.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("HistoryCommandController")
@RequestMapping("/records")
public class HistoryCommandController {

    private final HistoryService historyService;
    private final S3Service s3Service;
    private final VOMapper voMapper;

    @Autowired
    public HistoryCommandController(HistoryService historyService, S3Service s3Service,
                                    VOMapper voMapper) {
        this.historyService = historyService;
        this.s3Service = s3Service;
        this.voMapper = voMapper;
    }

    @PostMapping
    public ResponseEntity<HistoryResVO> addRecord(@RequestBody HistoryReqVO addData){

        HistoryDTO inputData = voMapper.INSTANCE.historyDTO(addData);

        if(historyService.addRecord(inputData)){
            HistoryResVO response = new HistoryResVO("/records/list", inputData);
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
    public ResponseEntity<HistoryResVO> modifyRecord(@PathVariable("id") int id,
                                                     @RequestBody HistoryReqVO data) {

        HistoryDTO modifyData = voMapper.INSTANCE.historyDTO(data);
        modifyData.setId(id);

        if(historyService.modifyRecord(modifyData)){

            return ResponseEntity.status(HttpStatus.OK).body(new HistoryResVO("/records/" + id, modifyData));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HistoryResVO> deleteRecord(@PathVariable("id") int id) {

        if(historyService.deleteRecord(id)){

            return ResponseEntity.status(HttpStatus.OK).body(new HistoryResVO("/records/list", null));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
