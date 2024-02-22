package com.example.filter.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE})//@OpenApi의 타겟은 메서드와 클래스(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenApi {
}
