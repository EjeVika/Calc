package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 28.06.13
 * Time: 0:45
 * To change this template use File | Settings | File Templates.
 */
public class DivCommand implements Command {
    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> define) {
        Double b = v.pop();
        Double a = v.pop();
        v.push(b/a);
    }

}
