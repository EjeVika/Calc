package com.sukhorukov.khudyakova.task2.test;

import com.sukhorukov.khudyakova.task2.Command;
import com.sukhorukov.khudyakova.task2.commands.SqrtCommand;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Stack;

/**

 */
public class TestCommandSqrt extends TestCase {


    public void testSqrt() throws Exception {


        HashMap<String, Double> define = new HashMap<>();
        Stack<Double> st = new Stack<>();
        Double a = 4.0;
        st.push(a);
        Command sqrtCmd = new SqrtCommand();
        sqrtCmd.execute(st,"",define);

        assertEquals(st.peek(),Math.sqrt(a),1.e-9);
        st.pop();
        assertEquals(st.peek(),-Math.sqrt(a),1.e-9);
    }
}
