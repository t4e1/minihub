package com.t4e1.minihub.command.memo.controller;

import com.t4e1.minihub.command.memo.vo.MemoReqVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("MemoCommandController")
@RequestMapping("/api/memos")
public class MemoController {

    @PostMapping("")
    public ResponseEntity<?> addNewMemo(@RequestBody MemoReqVO req){


        return null;
    }

}
