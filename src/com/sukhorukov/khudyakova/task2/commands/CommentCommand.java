package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.Map;
import java.util.Stack;

/**

 */
public class CommentCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, Map<String, Double> def) {
        System.out.println("Comment line was ignored");
    }


}
