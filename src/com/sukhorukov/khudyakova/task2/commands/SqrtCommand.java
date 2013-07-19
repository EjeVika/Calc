package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.AbstractCommand;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.Stack;
import java.lang.Math;

/**

 */
public class SqrtCommand extends AbstractCommand {


    public SqrtCommand() {
        super(1);
    }

    @Override
    public void executeImpl(String userInput) {
            Double a = st.pop();
            Double b = Math.sqrt(a);
            st.push(-b);    // negative root goes first
            st.push(b);     // positive root goes last
    }

    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
}
