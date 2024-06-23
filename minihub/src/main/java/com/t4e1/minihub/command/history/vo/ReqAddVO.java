package com.t4e1.minihub.command.history.vo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReqAddVO {

    private String title;
    private String content;
    private List<String> tags;
    private String pwd;
}
