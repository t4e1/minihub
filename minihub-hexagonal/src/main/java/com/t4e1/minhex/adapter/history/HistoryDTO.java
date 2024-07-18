package com.t4e1.minhex.adapter.history;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class HistoryDTO {

    private final int id;
    private final String title;
    private final String content;
    private final List<String> tags;
    private final String path;
    private final String pwd;
}
