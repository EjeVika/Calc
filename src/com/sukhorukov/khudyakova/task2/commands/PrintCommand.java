package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 28.06.13
 * Time: 23:45
 * To change this template use File | Settings | File Templates.
 */
public class PrintCommand implements Command {

    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> define) {
        System.out.println(v.lastElement());
    }

}
