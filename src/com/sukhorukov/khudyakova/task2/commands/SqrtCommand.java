package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;
import java.lang.Math;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 28.06.13
 * Time: 0:55
 * To change this template use File | Settings | File Templates.
 */
public class SqrtCommand implements Command {

    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> define) {
        Double a = v.pop();
        Double b = Math.sqrt(a);
        v.push(b);
    }
}
