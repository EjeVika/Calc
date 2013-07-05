package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**

 */
public class CommentCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, HashMap<String, Double> def) {
        System.out.println("Comment line was ignored");
    }


}
