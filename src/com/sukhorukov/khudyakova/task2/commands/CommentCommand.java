package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 29.06.13
 * Time: 0:47
 * To change this template use File | Settings | File Templates.
 */
public class CommentCommand implements Command {

    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> define) {
        System.out.println("Comment line was ignored");
    }


}
