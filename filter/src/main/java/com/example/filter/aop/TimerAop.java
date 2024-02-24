package com.example.filter.aop;

import com.example.filter.model.UserRequest;
import org.apache.catalina.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect//AOP를 정의하는 클래스에 할당됨
@Component//스프링으로부터 관리 됨
public class TimerAop {
    @Pointcut(value = "within(com.example.filter.controller.UserApiController)")//해당 컨트롤러가 가지고 있는 각각 메서드가 실행되는 전/후 시점 캐치,
    // "":pointcut을 실행시킬 위치
    public void timerPointCut(){

    }
    @Around(value = "timerPointCut()")//timerPointCut을 사용해서 Around 적용
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {//pointcut을 지정한 위치

        System.out.println("메서드 실행 이전");
        Arrays.stream(joinPoint.getArgs()).forEach( //.getArgs(): 해당 메서드가 실행될 때 들어가는 모든 매개변수를 불러오는 메서드
                it->{
                    if(it instanceof UserRequest){
                        var tempUser=(UserRequest)it;
                        tempUser.setPhoneNumber(tempUser.getPhoneNumber().replace("-",""));//들어온 번호에서 대시 삭제
                    }
                }
        );
        var newObj=Arrays.asList(new UserRequest());//배열도 설정 가능함, 임시로 null 값 넣음
        var stopWatch=new StopWatch();
        stopWatch.start();

        joinPoint.proceed(newObj.toArray());//메서드를 실행시키는 실질적인 메서드, 예외처리  필요

        stopWatch.stop();
        System.out.println("메서드 실행에 소요된 시간(ms): "+stopWatch.getTotalTimeMillis());

        System.out.println("메서드 실행 이후");
        //stopWatch.stop()가 여기 있어도 결과 같음

    }
}
