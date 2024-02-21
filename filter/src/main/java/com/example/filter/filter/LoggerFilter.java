package com.example.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component//service와 같은 스프링 빈 주입 방식
@Slf4j
/*
모든 요청과 응답은 필터를 지나가야 됨, 기준선은 chain.doFilter(request, response);
res는 talend api의 body 내용이라고 생각하면 됨, 실제로 안찍힐 수 있음(body가 없을 수 있음)
 */
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //진입 전
        log.info(">>>>>>진입");

            //실질적으로 컨트롤러에서 받는 request와 response를 변환 req, res가 받게 됨
        var req=new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res=new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(req, res);

        //진입 후
        var reqJson=new String(req.getContentAsByteArray());
        log.info("req: {}",reqJson);
        var resJson=new String(res.getContentAsByteArray());
        log.info("res: {}",resJson);

        //req.getContentAsByteArray();//content의 내용을 읽어옴
        log.info("<<<<<<리턴");

        res.copyBodyToResponse();//response를 위에서 읽어오고 한번 더 읽어오도록 하는 메서드(필수임)
    }
}
