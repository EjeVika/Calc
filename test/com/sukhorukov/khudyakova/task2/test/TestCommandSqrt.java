package com.sukhorukov.khudyakova.task2.test;

import com.sukhorukov.khudyakova.task2.Command;
import com.sukhorukov.khudyakova.task2.commands.SqrtCommand;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 03.07.13
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class TestCommandSqrt extends TestCase {
    public void setUp() throws Exception {

    }

    public void tearDown() throws Exception {

    }

    public void testExample1() throws Exception {
        String s = "a"+"bc";
        assertEquals("abc",s);

    }

    public void testSqrt() throws Exception {


        HashMap<String, Double> define = new HashMap<>();
        Stack<Double> st = new Stack<>();
        Double a = 4.0;
        st.push(a);
        Command sqrtCmd = new SqrtCommand();
        sqrtCmd.execute(st,"",define);


        assertEquals(st.peek(),Math.sqrt(a));
    }
}
