package com.t4e1.minihub.command.history.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HistoryDTO {

    private String title;
    private String content;
    private List<String> tags;

}
