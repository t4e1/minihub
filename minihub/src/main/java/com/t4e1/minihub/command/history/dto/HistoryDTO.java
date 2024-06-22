package com.t4e1.minihub.command.history.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDTO {

    private String title;
    private String content;
    private List<String> tags;
    private String pwd;
}
