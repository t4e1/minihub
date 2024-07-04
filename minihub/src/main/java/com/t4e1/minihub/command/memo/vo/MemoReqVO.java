package com.t4e1.minihub.command.memo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoReqVO {

    private final String title;
    private final String content;
    private final String pwd;

}
