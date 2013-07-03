package com.sukhorukov.khudyakova.task2;

/**
 * Created with IntelliJ IDEA.
 * User: ТСД
 * Date: 27.06.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 26.06.13
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    void execute(Stack<Double> v, String userInput, HashMap<String,Double> define);
}
