package com.t4e1.minihub.command.memo.controller;

import com.t4e1.minihub.command.memo.dto.MemoDTO;
import com.t4e1.minihub.command.memo.service.MemoService;
import com.t4e1.minihub.command.memo.vo.MemoReqVO;
import com.t4e1.minihub.command.memo.vo.MemoResVO;
import com.t4e1.minihub.common.converter.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("MemoCommandController")
@RequestMapping("/api/memos")
public class MemoController {

    private final MemoService memoService;
    private final VOMapper voMapper;

    @Autowired
    public MemoController(MemoService memoService,
                          @Qualifier("VOMapper") VOMapper voMapper) {
        this.memoService = memoService;
        this.voMapper = voMapper;
    }

    @PostMapping
    public ResponseEntity<MemoResVO> addNewMemo(@RequestBody MemoReqVO req){

        MemoDTO addData = voMapper.memoDTO(req);

        if(memoService.addNewMemo(addData)) {

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new MemoResVO("/api/memo", addData));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
