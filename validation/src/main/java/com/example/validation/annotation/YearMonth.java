package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import com.example.validation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class})//해당 PhoneNumberValidator을 검증하겠다
@Target({ElementType.FIELD})//변수에만 사용하겠다는 뜻
@Retention(RetentionPolicy.RUNTIME)//RUNTIME 중에만 사용하겠다는 뜻
@NotBlank

public @interface YearMonth {
    String message() default "Year Month 양식에 맞지 않습니다. 예) 2023-01";
   //String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";
    String pattern() default "yyyyMM";
    //@not null에서 붙여옴
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
