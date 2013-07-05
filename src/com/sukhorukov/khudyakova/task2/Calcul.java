package com.sukhorukov.khudyakova.task2;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**

 */
public class Calcul {

    public void executeCalculations(Scanner scan,CommandFactory cmdFactory,Stack<Double> st,HashMap<String,Double> def){
        // reading first input


        String userInput = scan.nextLine();


        while (!(userInput.equals("quit"))){

            String key=userInput.split(" ")[0];
            cmdFactory.getCommand(key).execute(st,userInput,def);
            userInput = scan.nextLine();
        }
    }

//    private Stack<Double> st;
//    private HashMap<String,Double> def;
//    private String userInput;
}
