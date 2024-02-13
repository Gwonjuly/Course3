package com.example.jpa.user.controller;

import com.example.jpa.user.db.UserEntity;
import com.example.jpa.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    //레파지토리를 스프링으로부터 주입 받을 거임임 @Required~~ 있어야 함
    private final UserRepository userRepository;

   @GetMapping("/find-all")
    public List<UserEntity> findAll(){
       return userRepository.findAll();
    }


    /*
    insert into `user`(
    `name`)
    values(
    'honggildong'); 와 동일
     */
    @GetMapping("/name")//Query variale 방식//http://localhost:8080/api/user/name?name=ABCD
    public void autoSave(@RequestParam String name){
       var user=UserEntity.builder()
               .name(name)
               .build();
       userRepository.save(user);
    }
}
