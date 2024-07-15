package com.t4e1.minhex.application.domain.history.command;

import lombok.Getter;

import java.util.List;

@Getter
public class History {
    private int id;
    private String title;
    private String content;
    private List<String> tags;
    private String pwd;


//   입력값 검증 로직 추가

//   기능 메소드 추가(추가된 BL을 가지고 History Service에서 호출하여 비즈니스 로직 구현)
}
