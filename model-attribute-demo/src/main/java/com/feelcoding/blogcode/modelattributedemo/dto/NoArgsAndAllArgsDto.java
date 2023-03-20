package com.feelcoding.blogcode.modelattributedemo.dto;

import lombok.Getter;

@Getter
public class NoArgsAndAllArgsDto {

    private String nickname;

    private Integer count;

    public NoArgsAndAllArgsDto() {
    }

    public NoArgsAndAllArgsDto(String nickname, Integer count) {
        this.nickname = nickname;
        this.count = count;
    }
}
