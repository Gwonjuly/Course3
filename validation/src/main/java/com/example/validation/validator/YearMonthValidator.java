package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

//[ConstraintValidator] 유효성을 체크하는 어노테이션을 제공하는 'javax.validation'에서 제공하는 인터페이스
public class YearMonthValidator implements ConstraintValidator<YearMonth,String> {//alt enter 후 메서드 구현
    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
        this.pattern= constraintAnnotation.pattern();
    }
/*
초기화를 할 때 해당 @에 있는 default 정규식을 가져와서 this.regexp에 저장
validation이 실행될 때 밑에 isValid 메서드가 실행 됨 value에 phoneNumber가 넘어오고 그 값을 검증 함
 */


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //사용자 value="2023-01-01T13:00:00"에서 "20230101"만 볼거임 즉 size=8
       /* if(value==null)
            return false;
        if(value.length()!=8)
            return false;//이거 @NotBlank 및 size(min,max)와 동일함(추가 ㄱㄱ)
            yyyy MM dd이지만 해당 검증은 yyyy MM까지임(어노테이션을 그렇게 만듦)
            */
        var reValue=value+"01";
        var rePattern=pattern+"dd";

        try{
            LocalDate date=LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));//어떠한 문자열로부터 local data를 만든다.
            System.out.println(date);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
