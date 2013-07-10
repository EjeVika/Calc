package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import java.lang.Math;

/**

 */
public class SqrtCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, Map<String, Double> def) {
        if (st.size()>=1){
            Double a = st.pop();
            Double b = Math.sqrt(a);
            st.push(-b);    // negative root goes first
            st.push(b);     // positive root goes last

        }else{
            throw new EmptyStackException();
        }
    }
}
