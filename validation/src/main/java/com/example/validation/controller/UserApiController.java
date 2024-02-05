package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {
/*
@Valid 요청이 들어올 때, 자동으로 해당 클래스에 붙어있는 어노테이션 기반으로 검증(UserRegisterRequest)
@RequestBody POST, PUT 방식에서 HTTP Body로 들어오는 데이터를 해당 객체에 맵핑시킴
 */
    //[방법 1]
   /* @PostMapping("")//path=""
    public UserRegisterRequest register(
            @Valid
            @RequestBody
            UserRegisterRequest userRegisterRequest
    ){
        log.info("init: {}", userRegisterRequest);
        return userRegisterRequest;
    }*/

    //[방법 2]; Api의 스펙을 통해서만 json을 보낼 수 있음
    /*
    [BindingResult]
    해당 valid가 실행 시, 해당 결과를 bindingresult에 당ㅁ아줌
    bindingresult: 에러 코드와 에러 카운트를 알 수 있음
     */
    @PostMapping("")
    public Api<UserRegisterRequest> requestApi(
            @Valid
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest//Body를 Api 형태로 보내야만 함
    ) {
       log.info("init:{}", userRegisterRequest);

        //request의 echo 방식
        var body = userRegisterRequest.getData();
        Api<UserRegisterRequest> response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))//ok 값: 200
                .resultMsg(HttpStatus.OK.getReasonPhrase())//ok 이유: ok
                .data(body)
                .build();

        return response;//talend 결과 에러 400
    }
}
