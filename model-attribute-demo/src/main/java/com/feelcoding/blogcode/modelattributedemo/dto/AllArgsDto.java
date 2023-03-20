package com.feelcoding.blogcode.modelattributedemo.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class AllArgsDto {

    private String nickname;

    private Integer count;

    public AllArgsDto(String nickname, Integer count) {
        this.nickname = nickname;
        this.count = count;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
