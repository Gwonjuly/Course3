package com.example.filter.config;

import com.example.filter.interceptor.OpenApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//config시 생성
public class WebConfig implements WebMvcConfigurer {

    @Autowired//@Controller 일 때, final 붙어야 함
    private OpenApiController openApiController;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);

        //임시 interceptor 기능 해제
        /*registry.addInterceptor(openApiController)//pattern pass: 어떤 주소에 맵핑을 하겠다고 지정
                .addPathPatterns("/**");//모든 주소 맵핑*/
    }
}
