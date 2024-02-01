package com.example.restapi.Controller;

import com.example.restapi.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@RestController//해당 컨트롤러를 REST API로 작동하겠다. 즉, 응답 값이 JSON으로 내려가겠다는 선언
@Controller//응답 값이 html으로 내려감
@RequestMapping("/api/v1")
/*
@RequestMapping(path="", methood=RequestMethod.GET)
= path로 메소드의 주소지정
= method: 해당 메소드는 get mothod만 받겠다고 선언, 즉 get mapping 이랑 동일하게 작동

@RequestMapping(path="")
= put, get, post 등 다 동작함
 */

/*
String 함수 (return .toString()): Content-type이 text
object(클래스) 함수 (return 클래스): Content-type이 JOSN
 */
public class ResponseApiController {
    //@GetMapping("")//디폴트 주소, path=""
    @RequestMapping(path="", method = RequestMethod.GET)
    @ResponseBody//@Controller 일 때, 응답이 html아닌 json임(반환은 아래처럼 클래스로)
    public UserInfo user(){
        var user=new UserInfo();
        user.setName("홍길동");
        user.setAge(12);
        user.setEmail("qwe@naver.com");
        log.info("user:{}", user);
        //return user.toString();//Content-type: text,응답이 text 형식으로 내려옴, 쓸 일 거의 없음
        return user;//object 즉, 클래스를 리턴하게 되면 Body의 내용을 스프링부트가 JSON으로 바궈서 응답을 내려줌
    }
/*
.status()
Response의 코드 지정 가능
HttpStatus.OK에 컨트롤+클릭
HttpStatus.OK=200, Talend의 RESPONSE 200
HttpStatus.CREATED=201, Talend의 RESPONSE 201
HttpStatus.BAD_REQUEST=400, Talend의 RESPONSE 201 (이때도 BODY 내려옴)

.header("",") 헤더 지정 가능
Response의 헤더

.body()
Response의 BODY 지정 가능
 */
    @GetMapping("/v2")
    public ResponseEntity<UserInfo> user1(){ //제네릭 안써도 상관없음
        var user1=new UserInfo();
        user1.setName("홍길동1");
        user1.setAge(13);
        user1.setEmail("asd@gmail.com");
        log.info("user1:{}",user1);
        var response=ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(user1);

        var response1=ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("x-custom","hi")
                .body(user1);

        return response1;

    }
}
