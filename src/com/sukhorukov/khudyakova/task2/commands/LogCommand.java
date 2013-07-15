package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 15.07.13
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class LogCommand implements Command {

    @Override
    public void execute(String userInput) {
        if (st.size()>=1){
            Double a = st.pop();
            st.push(Math.log(a));
        }else{
            throw new EmptyStackException();
        }
    }
    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}