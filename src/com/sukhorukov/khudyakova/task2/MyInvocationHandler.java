package com.sukhorukov.khudyakova.task2;

import org.apache.log4j.Logger;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Stack;

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
    private Stack<Double> st;
    private Map<String,Double> def;
    public MyInvocationHandler(Command cmd, Stack<Double> st, Map<String ,Double> def){
        this.cmd = cmd;
        this.st = st;
        this.def = def;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info(cmd.getClass().getSimpleName()+" is invoked");
        log.info("Stack before: "+st);
        log.info("Context: "+def);
        StringBuilder str = new StringBuilder("userInput");
        for (Field f:cmd.getClass().getDeclaredFields()){
             str = str.append(", "+f.getName());
        }
        log.info("Arguments: "+str.toString());
        try{
            method.invoke(cmd,args);
        }catch(InvocationTargetException e){
            throw e.getTargetException();
        }
        log.info("Stack after: "+st);

        return 0;

    }
}