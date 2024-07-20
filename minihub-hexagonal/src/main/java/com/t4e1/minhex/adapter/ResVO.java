package com.t4e1.minhex.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResVO<T> {

    private String nextUrl;
    private T data;
}
