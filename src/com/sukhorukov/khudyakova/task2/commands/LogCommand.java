package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.AbstractCommand;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.Stack;

/**

 */
public class LogCommand extends AbstractCommand {

    public LogCommand() {
        super(1);
    }


    @Override
    public void executeImpl(String userInput) {
            Double a = st.pop();
            st.push(Math.log(a));
    }

    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
