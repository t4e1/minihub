package com.t4e1.minihub.query.history.controller;

import com.t4e1.minihub.query.history.dto.RecordDTO;
import com.t4e1.minihub.query.history.service.HistoryService;
import com.t4e1.minihub.query.history.vo.ResListVO;
import com.t4e1.minihub.query.history.vo.ResRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("HistoryQueryController")
@RequestMapping("/record")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/list")
    public ResponseEntity<ResListVO> getAllRecord() {

        List<RecordDTO> result = historyService.getRecordList();
        ResListVO response = new ResListVO("/record/{id}", result);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResRecordVO> getRecord(@PathVariable("id") int id) {

        RecordDTO result = historyService.getRecord(id);
        ResRecordVO response= new ResRecordVO("/record/list", result);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
