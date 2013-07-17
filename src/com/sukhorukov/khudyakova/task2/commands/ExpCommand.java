package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.EmptyStackException;
import java.util.Stack;

/**

 */
public class ExpCommand extends Command {
    public ExpCommand(int minStackLength, Stack<Double> st) {
        super(minStackLength);

    }

    @Override
    public void executeImpl(String userInput) {
        if (st.size()>=1){
            Double a = st.pop();
            Double b = Math.exp(a);
            st.push(b);

        }else{
            throw new EmptyStackException();
        }
    }
    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
