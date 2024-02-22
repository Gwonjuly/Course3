package com.example.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
filter+Interceptor
진입(filter) -> pre handle -> post handle -> after completion -> 리턴(filter)
 */
@Slf4j
@Component//=service,repository
public class OpenApiController implements HandlerInterceptor {//인터페이스 클릭 후, ctrl + i
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //true= 컨트롤러로 전달, false= 미전달
        log.info("pre handle");

        return true;
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //ModelAndView: 화면에 뷰가 연결됐을 때 호출됨
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        log.info("post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        //해당 Exception은 컨트롤러에서 발생, config 필수(여기서는 WebConfig)
        log.info("after completion");
    }
}
