package com.sukhorukov.khudyakova.task2.test;


import com.sukhorukov.khudyakova.task2.Calcul;
import com.sukhorukov.khudyakova.task2.CommandFactory;
import junit.framework.TestCase;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**

 */

public class TestQuadrEquation extends TestCase {


     public void testQEqPosRoot() throws Exception {

        CommandFactory cmdFactory = new CommandFactory();
        Stack<Double> st = new Stack<>();
        HashMap<String,Double> def = new HashMap<>();
        String fileName1 = "/com/sukhorukov/khudyakova/task2/test/quadrEqTestPosRoot.txt";


        try(InputStream inputStrm = TestQuadrEquation.class.getResourceAsStream(fileName1)){

            Scanner scan = new Scanner(inputStrm);

            Calcul calculator = new Calcul();
            calculator.executeCalculations(scan,cmdFactory,st,def);

            Double a = def.get("a");
            Double b = def.get("b");
            Double c = def.get("c");

            Double x = (-b+Math.sqrt(b*b-4.0*a*c))/2.0/a;
            assertEquals(st.peek().toString(), x.toString());
            System.out.println(st.peek().toString()+" "+x.toString());
        }

    }

    public void testQEqNegRoot() throws Exception {
        CommandFactory cmdFactory = new CommandFactory();
        Stack<Double> st = new Stack<>();
        HashMap<String,Double> def = new HashMap<>();
        String fileName2 = "/com/sukhorukov/khudyakova/task2/test/quadrEqTestNegRoot.txt";
        try(InputStream inputStrm = TestQuadrEquation.class.getResourceAsStream(fileName2)){

            Scanner scan = new Scanner(inputStrm);

            Calcul calculator = new Calcul();
            calculator.executeCalculations(scan,cmdFactory,st,def);

            Double a = def.get("a");
            Double b = def.get("b");
            Double c = def.get("c");

            Double x = (-b-Math.sqrt(b*b-4.0*a*c))/2.0/a;
            assertEquals(st.peek().toString(),x.toString());
            System.out.println(st.peek().toString()+" "+x.toString());
        }
    }
}
