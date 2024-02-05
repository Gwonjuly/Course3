package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PhoneNumberValidator.class})//해당 PhoneNumberValidator을 검증하겠다
@Target({ElementType.FIELD})//변수에만 사용하겠다는 뜻
@Retention(RetentionPolicy.RUNTIME)//RUNTIME 중에만 사용하겠다는 뜻
public @interface PhoneNumber {
    String message() default "핸드폰 번호 양식에 맞지 않습니다. 예) 000-0000-0000";
    String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";
    //@not null에서 붙여옴
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
