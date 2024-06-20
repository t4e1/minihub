package com.t4e1.minihub.query.history.aggregate;

import lombok.Builder;

@Builder
public class SelectCondition {

    private String title;
    private String content;
    private String tag;
    private int offset;
    private int num;

    public SelectCondition(String title, String content, String tag, int offset, int num) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.offset = offset;
        this.num = num;
    }
}
