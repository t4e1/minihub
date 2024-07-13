package com.t4e1.minihub.adapter.in.history.vo;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class HistoryReqVO {

    private String title;
    private String content;
    private List<String> tags;
    private String pwd;
}
