package com.example.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
filter+Interceptor
진입(filter) -> pre handle -> post handle -> after completion -> 리턴(filter)
 */
@Slf4j
@Component//=service,repository
public class OpenApiController implements HandlerInterceptor {//인터페이스 클릭 후, ctrl + i

    /*
    @param handler: 전달할 컨트롤러에 대한 정보
    getMethodAnnotation: 해당 어노테이션을 가지고 있는지를 검사
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //true= 컨트롤러로 전달, false= 미전달
        log.info("pre handle");
        var handlerMethood = (HandlerMethod) handler;
        var methodLevel=handlerMethood.getMethodAnnotation(OpenApi.class);//methodlevel에서 openapi를 가지고 있는가? 있으면 not null, 없으면 null
        if(methodLevel!=null){
            log.info("해당 메서는 @OpenApi를 가지고 있음");
            return true;
        }

        var classLevel=handlerMethood.getMethodAnnotation(OpenApi.class);//해당 클래스에 openapi를 가지고 있는가?
        if(classLevel!=null){
           log.info("해당 클래스는 @OpenApi를 가지고 있음");
            return true;
        }

        log.info("해당 주소는 @OpenApi 없음: {}",request.getRequestURI());
        return false;
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
