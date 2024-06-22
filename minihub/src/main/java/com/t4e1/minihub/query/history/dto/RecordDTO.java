package com.t4e1.minihub.query.history.dto;

import lombok.Data;
import java.util.List;

@Data
public class RecordDTO {

    private int id;
    private String title;
    private String content;
    private List<String> tags;
    private String pwd;

}
