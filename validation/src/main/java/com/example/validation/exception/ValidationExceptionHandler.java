package com.example.validation.exception;

import com.example.validation.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice //REST API가 사용하는 곳에서 모든 예외가 일어나는 것을 감지
public class ValidationExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Api> validationException(
            MethodArgumentNotValidException exception
    ){
        log.error("",exception);
        var errMsgList=exception.getFieldErrors().stream()//bindingresult -> exception
                .map(it->{
                    var format="%s :{%s}은 %s";
                    var msg=String.format(format,it.getField(),it.getRejectedValue(),it.getDefaultMessage());
                    return msg;
                }).collect(Collectors.toList());
        var err=Api.Error.builder()
                .errorMsg(errMsgList)
                .build();

        var errResponse=Api.builder()
                .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMsg(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .error(err)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errResponse);
    }
}
