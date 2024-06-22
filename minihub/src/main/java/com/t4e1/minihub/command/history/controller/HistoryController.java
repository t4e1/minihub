package com.t4e1.minihub.command.history.controller;

import com.t4e1.minihub.command.aws.S3Service;
import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.service.HistoryService;
import com.t4e1.minihub.command.history.vo.ReqAddVO;
import com.t4e1.minihub.command.history.vo.ResAddVO;
import com.t4e1.minihub.common.converter.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController("HistoryCommandController")
@RequestMapping("/records")
public class HistoryController {

    private final HistoryService historyService;
    private final S3Service s3Service;
    private final VOMapper voMapper;

    @Autowired
    public HistoryController(HistoryService historyService, S3Service s3Service,
                             VOMapper voMapper) {
        this.historyService = historyService;
        this.s3Service = s3Service;
        this.voMapper = voMapper;
    }

    @PostMapping
    public ResponseEntity<ResAddVO> addRecord(@RequestBody ReqAddVO addData){

        HistoryDTO result = historyService.addRecord(voMapper.historyDTO(addData));
        ResAddVO response = new ResAddVO("/records/list", result);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/images")
    public ResponseEntity<List<String>> addImages(List<MultipartFile> files) {

        List<String> response = s3Service.s3Upload(files);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
