package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**

 */
public class PopCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, Map<String, Double> def) {
        if (st.size()>=1){
            st.pop();
        }else{
            throw new EmptyStackException();
        }
    }

}
