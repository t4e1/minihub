package com.t4e1.minihub.command.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
public class MemoDTO {

    private int id;
    private String title;
    private String content;
    private int scheduleId;

}
