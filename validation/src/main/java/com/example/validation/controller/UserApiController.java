package com.example.validation.controller;

import com.example.validation.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")//path=""
    public UserRegisterRequest register(
            @RequestBody//POST, PUT 방식에서 HTTP Body로 들어오는 데이터를 해당 객체에 맵핑시킴
            UserRegisterRequest userRegisterRequest
    ){
        log.info("init:{}",userRegisterRequest);
        return userRegisterRequest;
    }
}
