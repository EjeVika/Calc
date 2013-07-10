package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;


import java.util.Map;
import java.util.Stack;

/**

 */
public class DefineCommand implements Command {
    @Override
    public void execute(Stack<Double> st, String userInput, Map<String, Double> def) {
        String[] mas = userInput.split(" ");
        Double d=new Double(mas[2]);
        def.put(mas[1],d);

    }
}
