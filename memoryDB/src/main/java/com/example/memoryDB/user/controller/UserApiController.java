package com.example.memoryDB.user.controller;

import com.example.memoryDB.user.model.UserEntity;
import com.example.memoryDB.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
컨트롤러 -> 서비스: 요청, 서비스는 비즈니스 로직을 처리(데이터베이스의 repository를 이용하여 특정 데이터 처리
컨트롤러 <- 서비스: 응답, 서비스는 처리 후 컨트롤러에게 응답을 줌
 */
@Controller//HTTP 리퀘스트가 들어오는 내용을 처리하고 response를 처리하는 영역
@RequestMapping("/api/user")
@RequiredArgsConstructor//생성자 메서드로 채워달라는 어노테이션(final UserService에 적용되나?)
public class UserApiController {

    private final UserService userService;

    //UserEntity가 아닌 UserResponse라 생각하면 됨(응답)
    @PutMapping("")//create를 통해 업데이트 또는 생성을 하기에 post가 아닌 put,
    //GET 방식과 다르게 데이터를 객체로 받아야 한다. (GET은 변수 OR 객체 상관없음)
    public UserEntity create(
            @RequestBody UserEntity userEntity//@: POST, PUT 방식에서 HTTP Body로 들어오는 데이터를 해당 객체에 맵핑시킴
    ){
        return userService.save(userEntity);//사용자로부터 들어온 내용을 save 후 리턴
    }
    //이게 지금 데이터를 받아서 서비스에게 save를 요청하는 건가?

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }
}
