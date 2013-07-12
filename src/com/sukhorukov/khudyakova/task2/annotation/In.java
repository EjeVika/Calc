package com.sukhorukov.khudyakova.task2.annotation;

import com.sukhorukov.khudyakova.task2.annotation.EnumArg;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 10.07.13
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface In {
    EnumArg typeArg();
}
