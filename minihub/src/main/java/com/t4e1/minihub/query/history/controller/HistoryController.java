package com.t4e1.minihub.query.history.controller;

import com.t4e1.minihub.common.paging.ScrollPaging;
import com.t4e1.minihub.query.history.dto.RecordDTO;
import com.t4e1.minihub.query.history.service.HistoryService;
import com.t4e1.minihub.query.history.vo.ResListVO;
import com.t4e1.minihub.query.history.vo.ResRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("HistoryQueryController")
@RequestMapping("/records")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/list")
    public ResponseEntity<ResListVO> getAllRecord(@RequestParam(required = false, name = "title") String title,
                                                  @RequestParam(required = false, name = "content") String content,
                                                  @RequestParam(required = false, name = "tag") List<String> tag,
                                                  @RequestParam("page") int page,
                                                  @RequestParam("num") int num) {

        ScrollPaging paging = new ScrollPaging(page, num);

        List<RecordDTO> result = historyService.getRecordList(title, content, tag, paging);
        ResListVO response = new ResListVO("/record/{id}", result, paging);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResRecordVO> getRecord(@PathVariable("id") int id) {

        RecordDTO result = historyService.getRecord(id);
        ResRecordVO response= new ResRecordVO("/record/list", result);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
