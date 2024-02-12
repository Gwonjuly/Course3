package com.example.jpa.user.controller;

import com.example.jpa.db.UserEntity;
import com.example.jpa.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    //레파지토리를 스프링으로부터 주입 받을 거임임 @Required~~ 있어야 함
    @Autowired
    private final UserRepository userRepository;

   @GetMapping("/find-all")
    public List<UserEntity> findAll(){
       return userRepository.findAll();
    }
}
