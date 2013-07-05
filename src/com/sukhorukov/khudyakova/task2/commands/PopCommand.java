package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**

 */
public class PopCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, HashMap<String, Double> def) {
        try{
            st.pop();
        }catch (EmptyStackException e){
            System.out.println("Stack is already empty.");
        }
    }

}
