package com.t4e1.minhex.adapter.in.history.vo;

import com.t4e1.minhex.adapter.in.history.dto.HistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResVO {

    private String nextUrl;
    private HistoryDTO resultDTO;
}
