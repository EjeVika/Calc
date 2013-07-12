package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.EmptyStackException;
import java.util.Stack;

/**

 */
public class DivCommand implements Command {
    @Override
    public void execute(String userInput) {
        if (st.size()>=2){
            Double a = st.pop();
            Double b = st.pop();
            st.push(b/a);
        }else{
            throw new EmptyStackException();
        }
    }
    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
