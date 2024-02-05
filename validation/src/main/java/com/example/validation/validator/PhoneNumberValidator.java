package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

//[ConstraintValidator] 유효성을 체크하는 어노테이션을 제공하는 'javax.validation'에서 제공하는 인터페이스
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {//alt enter 후 메서드 구현
    private String regexp;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
        this.regexp= constraintAnnotation.regexp();
    }
/*
초기화를 할 때 해당 @에 있는 default 정규식을 가져와서 this.regexp에 저장
validation이 실행될 때 밑에 isValid 메서드가 실행 됨 value에 phoneNumber가 넘어오고 그 값을 검증 함
 */


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result= Pattern.matches(regexp,value);//phoneNumber와 regexp(정규식)과 일치하는지 확인(순서  바뀜)
        return result;
    }
}
