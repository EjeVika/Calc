package com.sukhorukov.khudyakova.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/**

 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchFieldException {
        InputStream inputStrm =null;
        try{

            inputStrm = System.in;
            //String fileName = "Test.txt";
            String fileName = "";
            if (!fileName.equals("")){
                inputStrm = new FileInputStream(fileName);
            }

            Scanner scan = new Scanner(inputStrm);

            Stack<Double> st = new Stack<>();
            Map<String,Double> def = new HashMap<>();
            CommandFactory cmdFactory = new CommandFactory(st,def);
        //    System.out.println("im in main");
            Calcul calculator = new Calcul();
            calculator.executeCalculations(scan,cmdFactory,st,def);
        } finally{
            if(inputStrm!=null) inputStrm.close();
        }
    }  // end of psvm

}   // end of Main class
