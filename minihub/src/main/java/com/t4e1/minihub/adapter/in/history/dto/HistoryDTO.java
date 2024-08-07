package com.t4e1.minihub.adapter.in.history.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class HistoryDTO {

        private int id;
        private String title;
        private String content;
        private List<String> tags;
        private String path;
        private String pwd;
}

