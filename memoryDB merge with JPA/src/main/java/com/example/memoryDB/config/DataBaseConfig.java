//package com.example.memoryDB.config;
//
//import com.example.memoryDB.user.db.UserRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
///*
//보통 외부 클래스를 사용할 때
//스프링 앱이 실행될 때 이 @를 찾아서 특정한 내용들을 Spring Context라는 영역에 new 생성자를 통해 객체 생성
//사용하고자 하는 서비스, 컨트롤러 또는 각각의 bin으로 만들어진 영역들 사이에서 여기(new 생성자를 통해 만든 객체)에 대한 내용이 필요하다면 스프링이 알아서 주입
// */
//@Configuration//여긴 설정이라는 뜻,
//public class DataBaseConfig {
//
//    @Bean//이건 빈임, 이제 이 객체는 bin으로 만들어지면서 스프링에 의해 관리됨, 이 방식은 빈을 직접 등록
//    public UserRepository userRepository(){
//        return new UserRepository();//new 생성자를 통해 객체 생성
//    }
//}
