package com.t4e1.minihub.query.history.vo;

import com.t4e1.minihub.query.history.dto.RecordDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ResRecordVO {

    private String nextUrl;
    private RecordDTO result;
}
