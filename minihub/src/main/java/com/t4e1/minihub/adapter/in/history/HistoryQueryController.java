package com.t4e1.minihub.adapter.in.history;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.common.paging.ScrollPaging;
import com.t4e1.minihub.query.history.service.HistoryService;
import com.t4e1.minihub.adapter.in.history.vo.HistoryResListVO;
import com.t4e1.minihub.query.history.vo.ResRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("HistoryQueryController")
@RequestMapping("/records")
public class HistoryQueryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryQueryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/list")
    public ResponseEntity<HistoryResListVO> getAllRecord(@RequestParam(required = false, name = "title") String title,
                                                         @RequestParam(required = false, name = "content") String content,
                                                         @RequestParam(required = false, name = "tag") List<String> tag,
                                                         @RequestParam("page") int page,
                                                         @RequestParam("num") int num) {

        ScrollPaging paging = new ScrollPaging(page, num);

        List<HistoryDTO> result = historyService.getRecordList(title, content, tag, paging);
        HistoryResListVO response = new HistoryResListVO("/record/{id}", result, paging);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResRecordVO> getRecord(@PathVariable("id") int id) {

        HistoryDTO result = historyService.getRecord(id);
        ResRecordVO response= new ResRecordVO("/record/list", result);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
