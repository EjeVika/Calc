package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**

 */
public class MultCommand implements Command {
    @Override
    public void execute(Stack<Double> st, String userInput, Map<String, Double> def) {
        if (st.size()>=2){
            Double a = st.pop();
            Double b = st.pop();
            st.push(a*b);
        }else{
            throw new EmptyStackException();
        }

    }

}
