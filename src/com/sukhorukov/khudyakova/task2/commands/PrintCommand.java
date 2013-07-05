package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**

 */
public class PrintCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, HashMap<String, Double> def) {
        try{
            System.out.println(st.peek());
        }catch (EmptyStackException e){
            System.out.println("Stack is empty.");
        }
    }

}
