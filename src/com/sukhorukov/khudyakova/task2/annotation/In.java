package com.sukhorukov.khudyakova.task2.annotation;

import com.sukhorukov.khudyakova.task2.annotation.EnumArg;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**

 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface In {
    EnumArg typeArg();
}
