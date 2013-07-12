package com.sukhorukov.khudyakova.task2;

import org.apache.log4j.Logger;


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
    private static final Logger log = Logger.getLogger(MyInvocationHandler.class);
    private Command cmd;
    public MyInvocationHandler(Command cmd){
        this.cmd = cmd;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // st
        log.error("error error");
        log.warn("warn warn");
        log.info("info info");
        log.debug("debug debug");
        log.trace("trace trace");
        method.invoke(cmd,args);
        return 0;

    }
}