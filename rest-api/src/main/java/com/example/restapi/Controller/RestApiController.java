package com.example.restapi.Controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //REST API를 처리하는 컨트롤러
@RequestMapping("/api") //api로 시작하는 주소를 이 컨트롤러에서 요청을 받겠다 라는 뜻임
public class RestApiController {
    /*
    서버의 컨트롤러에서 /api를 가진 주소는 rest 컨트롤러가  처리
    /api/hello를 가진 주소는 이 컨트롤러의 hello 메서드가 처리
     */
    @GetMapping(path = "/hello")//path: "주소들(/api) 중 어떠한 주소(/hello)를 처리하겠다" 라는 뜻
    public String hello(){
        //주소 http://localhost:8080/api/hello
        //return "Hello String Boot";//Content Type은 text(utf-8)로  인코딩 되어 있음
        var html="<html><body><h1> Hello String Boot </h1></body></html>";//Content Type은 text임 위의 문자열 형태에서 html 형태로 변경된 것 뿐임
        return html;
    }

    /*
    [GET의 PATH Variable 방식]
    -@PathVarialbe-
    @getmapping의 {}의 값과 @pathvariable의 변수를 동일하게 선언해야 함
    path variable의 값은 중괄호{}로 넣어줌, 주소는 대문자 허용 안됨(isman)
    /api/echo/라는 주소에 특정한 path variable 값(message)가 들어오면 String 형태로 파싱해서 출력
    어노테이션으로 작성하여 echo 메서드로 연결됨
     */
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
        @PathVariable String message, //=(@PathVariable (name="message") String msg)로 다르게 변수 사용 가능
        @PathVariable int age, //Integer는 null이 들어로 수 있기에 pathvariable에 적합하지 않음(404에러 발생할 수 있음)
        @PathVariable Boolean isMan
    )
    {
        //주소 http://localhost:8080/api/echo/{message} 임 message에 "hello"를 넣을 경우
        //    http://localhost:8080/api/echo/hello
        //    http://localhost:8080/api/echo/helo/age/26/is-man/true
        String str=message.toUpperCase();
        System.out.println("echo message:" +message);//서버에 보낸 값은 소문자고(주소에 치는 값)
        System.out.println("echo Upper message:" +str);//서버의 응답은 대문자
        return str;
    }

    /*
    [GET의 Query Variable 방식]
    @RequestParam
     */
    //http://localhost:8080/book?category=IT&issuedYear=2024y&issued-month=9m&issued_day=25
    @GetMapping(path="/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam (name="issued-month") String issuedMonth,
            @RequestParam String issued_day
    )
    {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issued_day);
    }

    //http://localhost:8080/book2?category=IT&issuedYear=2024y&issued-month=9m&issued_day=25
    /*
    BookQueryParam에서 데이터 받음 @RequestParam 어노테이션은 입력 안함
     */
    @GetMapping(path="/book2")
    public void queryParam2(
            /*@RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam (name="issued-month") String issuedMonth,
            @RequestParam (name="issued_day") String issuedDay*/
            BookQueryParam bookQueryParam
    )
    {
        /*System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);*/
        System.out.println(bookQueryParam);
    }

    //http://localhost:8080/api/operation?i=10&j=20&b=false
    @GetMapping(path = "/operation")
    public void operation(
            @RequestParam int i,
            @RequestParam int j,
            @RequestParam Boolean b
    ){
        int sum1=i+j;
        int sum2=i*j;
        System.out.println("합: " +sum1);
        System.out.println("곱: "+sum2);
        System.out.println(b);
    }

    @DeleteMapping(path = {//PathVariale 방식
            "/user/{name}/delete",
            "/user/{name}/del"
    }) //주소 여러개 보낼 수도 있음
        public void delete(
                @PathVariable String name
    ){
        log.info("name:{}", name);
        }

}
