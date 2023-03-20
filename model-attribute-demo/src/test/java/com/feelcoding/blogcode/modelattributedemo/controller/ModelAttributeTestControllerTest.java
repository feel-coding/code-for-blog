package com.feelcoding.blogcode.modelattributedemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feelcoding.blogcode.modelattributedemo.dto.AllArgsDto;
import com.feelcoding.blogcode.modelattributedemo.dto.NoArgsAndAllArgsDto;
import com.feelcoding.blogcode.modelattributedemo.dto.NoArgsAndSetterDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.sharedHttpSession;

@WebMvcTest(ModelAttributeTestController.class)
class ModelAttributeTestControllerTest {

    @Autowired
    private MockMvc mvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup(WebApplicationContext webApplicationContext) {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(sharedHttpSession())
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    @DisplayName("NoArgsConstructor와 AllArgsConstructor가 있을 때 값이 할당이 잘 되는지 테스트")
    void test1() throws Exception {
        NoArgsAndAllArgsDto requestDto = new NoArgsAndAllArgsDto("feelcoding", 100);

        mvc.perform(post("/test/no-args-and-all-args")
                .contentType(MediaType.APPLICATION_JSON)
                        .param("nickname", requestDto.getNickname())
                        .param("count", requestDto.getCount().toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(requestDto)));

    }

    @Test
    @DisplayName("AllArgsConstructor만 있을 때 값이 할당이 잘 되는지 테스트")
    void test2() throws Exception {
        AllArgsDto requestDto = new AllArgsDto("feelcoding", 100);

        mvc.perform(post("/test/all-args-only")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("nickname", requestDto.getNickname())
                        .param("count", requestDto.getCount().toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(requestDto)))
                .andDo(print());
    }

    @Test
    @DisplayName("NoArgsConstructor와 Setter가 있을 때 값이 할당이 잘 되는지 테스트")
    void test3() throws Exception {
        NoArgsAndSetterDto requestDto = new NoArgsAndSetterDto();
        requestDto.setNickname("feelcoding");
        requestDto.setCount(100);

        mvc.perform(post("/test/no-args-and-setter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("nickname", requestDto.getNickname())
                        .param("count", requestDto.getCount().toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(requestDto)))
                .andDo(print());
    }

}