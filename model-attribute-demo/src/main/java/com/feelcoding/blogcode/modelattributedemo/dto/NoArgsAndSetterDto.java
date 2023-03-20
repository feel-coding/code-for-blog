package com.feelcoding.blogcode.modelattributedemo.dto;

import lombok.Getter;

@Getter
public class NoArgsAndSetterDto {

    private String nickname;

    private Integer count;

    public NoArgsAndSetterDto() {
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
