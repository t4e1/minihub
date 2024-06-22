package com.t4e1.minihub.command.history.vo;

import com.t4e1.minihub.command.history.dto.HistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResAddVO {

    private String nextUrl;
    private HistoryDTO result;

}
