package com.feelcoding.blogcode.modelattributedemo.controller;

import com.feelcoding.blogcode.modelattributedemo.dto.AllArgsDto;
import com.feelcoding.blogcode.modelattributedemo.dto.NoArgsAndAllArgsDto;
import com.feelcoding.blogcode.modelattributedemo.dto.NoArgsAndSetterDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ModelAttributeTestController {

    @PostMapping("/no-args-and-all-args")
    public NoArgsAndAllArgsDto test1(@ModelAttribute NoArgsAndAllArgsDto requestDto) {
        return requestDto;
    }

    @PostMapping("/all-args-only")
    public AllArgsDto test2(@ModelAttribute AllArgsDto requestDto) {
        return requestDto;
    }

    @PostMapping("/no-args-and-setter")
    public NoArgsAndSetterDto test3(@ModelAttribute NoArgsAndSetterDto requestDto) {
        return requestDto;
    }

}
