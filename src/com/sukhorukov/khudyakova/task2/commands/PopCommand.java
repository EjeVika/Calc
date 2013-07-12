package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.EmptyStackException;
import java.util.Stack;

/**

 */
public class PopCommand implements Command {

    @Override
    public void execute(String userInput) {
        if (st.size()>=1){
            st.pop();
        }else{
            throw new EmptyStackException();
        }
    }
    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
