package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**

 */
public class PushCommand implements Command {

    @Override
    public void execute(Stack<Double> st, String userInput, HashMap<String, Double> def) {

        String[] mas = userInput.split(" ");
        try{

            double pushValue = 0.0;
            boolean flag = false;
            // check the presence of parameter in def and, if found, define pushValue
            if (!def.isEmpty()){
                for (String str: def.keySet()){
                    if (str.equals(mas[1])){
                        pushValue = def.get(str);
                        flag = true;
                    }
                }
            }
           try{
                if (flag){
                    st.push(pushValue);
                }else {
                    st.push(new Double(mas[1]) );
                }
           }catch (NumberFormatException e){
               System.out.println("The parameter \""+mas[1]+"\" is not defined" );
           }
        } catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Number of arguments of PUSH command is wrong");
        }
    }
}
