package com.t4e1.minihub.command.history.vo;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class ReqVO {

    private String title;
    private String content;
    private List<String> tags;
    private String pwd;
}
