package com.t4e1.minihub.command.memo.vo;

import com.t4e1.minihub.command.memo.dto.MemoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoResVO {

    private final String nextUrl;
    private final MemoDTO resultDTO;

}
