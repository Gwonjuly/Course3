package com.example.filter.controller;

import com.example.filter.interceptor.OpenApi;
import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApiController {

    @OpenApi//openapi (0)
    @PostMapping("")
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("{}",userRequest);
        throw new NumberFormatException("");// @AfterThrowing 테스트를 위해 임의의 에러 발생
        //return userRequest;
    }

    //openapi (x)
    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }
}
