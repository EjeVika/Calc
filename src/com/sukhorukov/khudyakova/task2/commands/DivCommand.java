package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**

 */
public class DivCommand implements Command {
    @Override
    public void execute(Stack<Double> st, String userInput, HashMap<String, Double> def) {
        try{
            Double a = st.pop();
            try{
                Double b = st.pop();
                st.push(b/a);
            }catch (EmptyStackException e){
                System.out.println("Stack is empty. Can't find dividend.");
                st.push(a);
            }
        }catch (EmptyStackException e){
            System.out.println("Stack is empty. Can't find divisor.");
        }
    }

}
