package com.example.restapi.Controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserInfo;
import org.springframework.web.bind.annotation.*;

/*
[POST 방식]
1. GET 방식과 다르게 데이터를 객체로 받아야 한다. (GET은 변수 OR 객체 상관없음)
2.@RequestBody: POST, PUT 방식에서 HTTP Body로 들어오는 데이터를 해당 객체에 맵핑시킴
 */
@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    public String post( //BookRequest로 하면 json 형식으로 받음
            @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    @PostMapping("/user")
    public UserInfo user(
            @RequestBody UserInfo userInfo //역직렬화를 통해 (json -> dto) 객체를 만듦
    ){
        System.out.println(userInfo);
        return userInfo;//직렬화를 통해 (dto -> json) 리턴
    }
}
