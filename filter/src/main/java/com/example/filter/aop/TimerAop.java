package com.example.filter.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
        joinPoint.proceed();//메서드를 실행시키는 실질적인 메서드, 예외처리  필요
        System.out.println("메서드 실행 이후");
    }
}
