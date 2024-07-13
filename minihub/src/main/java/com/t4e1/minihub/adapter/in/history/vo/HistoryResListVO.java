package com.t4e1.minihub.adapter.in.history.vo;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.common.paging.ScrollPaging;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HistoryResListVO {

    private String nextUrl;
    private List<HistoryDTO> result;
    private ScrollPaging paging;

}
