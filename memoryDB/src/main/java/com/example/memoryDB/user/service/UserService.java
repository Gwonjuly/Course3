package com.example.memoryDB.user.service;

import com.example.memoryDB.user.db.UserRepository;
import com.example.memoryDB.user.model.UserEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//서비스 로직이 들어가는 빈의 영역, 즉 데이터베이스의 영역임을 표시, 그래서 userApi컨트롤러에서 빈이 자동으로 등록된건가?
@RequiredArgsConstructor//생성자 메서드로 채워달라는 어노테이션(final UserRepository에 적용되나?)
public class UserService {

    private final UserRepository userRepository;//@Service와 반대로 userRepsotiry는 @Respository가 없어서 빈이 자동으로 등록안된거?
    //UseService라는 객체가 생성될 때, @Required~ 을 사용하여 생성자 메서드를 주입(위에 선언만 하고 객체 생성 안함)
    //dbConfig를 통해 스프링이 UserRepository 생성자를 여기로 주입, 이 방식은 외부 클래스를 사용할 때
    //보통은 @Service 사용 인프런 보니까 @Repository, @Controller 가능
    public UserEntity save(UserEntity user){
        return userRepository.save(user);//userRepository가 simple을 상속받음 즉, simple의 save 함수 호출
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();//userRepository가 simple을 상속받음 즉, simple의 findAll 함수 호출
    }
}
