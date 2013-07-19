package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.AbstractCommand;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.Stack;

/**

 */
public class SubtrCommand extends AbstractCommand {


    public SubtrCommand() {
        super(2);
    }

    @Override
    public void executeImpl(String userInput) {
            Double a = st.pop();
            Double b = st.pop();
            st.push(b-a);
    }

    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
