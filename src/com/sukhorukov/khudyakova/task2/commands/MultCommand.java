package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**

 */
public class MultCommand implements Command {
    @Override
    public void execute(Stack<Double> st, String userInput, HashMap<String, Double> def) {
        try{
            Double a = st.pop();
            try{
                Double b = st.pop();
                st.push(a*b);
            }catch (EmptyStackException e){
                System.out.println("Stack is empty. Can't find second multiplier.");
                st.push(a);
            }
        }catch (EmptyStackException e){
            System.out.println("Stack is empty. Can't find first multiplier.");
        }

    }

}
