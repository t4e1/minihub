package com.t4e1.minihub.query.history.vo;

import com.t4e1.minihub.query.history.dto.RecordDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResListVO {

    private String nextUrl;
    private List<RecordDTO> list;

}
