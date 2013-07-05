package com.sukhorukov.khudyakova.task2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


/**

 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        InputStream inputStrm =null;
        try{
            //choosing the
            inputStrm = System.in;
            //String fileName = "quadrEqTestPosRoot.txt";
            String fileName = "";
            if (!fileName.equals("")){
                inputStrm = Main.class.getResourceAsStream(fileName);
            }

            Scanner scan = new Scanner(inputStrm);
            CommandFactory cmdFactory = new CommandFactory();
            Stack<Double> st = new Stack<>();
            HashMap<String,Double> def = new HashMap<>();

            Calcul calculator = new Calcul();
            calculator.executeCalculations(scan,cmdFactory,st,def);
        } finally{
            if(inputStrm!=null) inputStrm.close();
        }
    }  // end of psvm

}   // end of Main class
