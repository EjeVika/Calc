package com.sukhorukov.khudyakova.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 12.07.13
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Command cmd;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        cmd = (Command)proxy;
        System.out.println("la-la-la");
        return proxy;
    }
}
