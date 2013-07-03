package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 26.06.13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class PushCommand implements Command {

    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> define) {

        String[] mas = userInput.split(" ");

        double pushValue = 0.0;

        if (!define.isEmpty()){
            for (Object str: define.keySet()){

                if (str.equals(mas[1])){
                    pushValue = define.get(str);

                }
            }
        }

        if (pushValue==0.0){
            String d=mas[1];
            v.push(new Double(d) );
        }
        else {

            v.push(pushValue);
        }

    }
}
