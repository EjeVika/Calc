package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.AbstractCommand;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.Stack;

/**

 */
public class PrintCommand extends AbstractCommand {


    public PrintCommand() {
        super(1);
    }

    @Override
    public void executeImpl(String userInput) {
            System.out.println(st.peek());
    }

    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
