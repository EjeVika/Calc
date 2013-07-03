package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 02.07.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
public class DefineCommand implements Command {
    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> define) {
        String[] mas = userInput.split(" ");
        Double d=new Double(mas[2]);
        define.put(mas[1],d);

    }
}
