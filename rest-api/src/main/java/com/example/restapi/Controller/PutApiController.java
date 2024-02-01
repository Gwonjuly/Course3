package com.example.restapi.Controller;

import com.example.restapi.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
[PUT 방식]
POST와의 차이점은 데이터가 없으면 생성하는 것은 같으나,
데이터가 존재할 경우 PUT은 업데이트 함
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put")
    public void put(
        @RequestBody UserInfo userInfo
        ){
        log.info("Request :{}",userInfo);//println보다 훨씬 속도가 빠름
    }
}
