package com.sukhorukov.khudyakova.task2;



import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**

 */
public class Calcul {


    public void executeCalculations(Scanner scan,CommandFactory cmdFactory){

        Set<String> cmdDictionary= cmdFactory.getKeySet();

        while (scan.hasNextLine()){
            String userInput = scan.nextLine();
            if (!userInput.equals("quit")){
                String key=userInput.split(" ")[0].toUpperCase();
                if (cmdDictionary.contains(key)){
                    try{
                        cmdFactory.getCommand(key).execute(userInput);
                    }catch(EmptyStackException e){
                        System.err.println("Stack doesn't contain enough elements");
                    }catch (NumberFormatException|ArrayIndexOutOfBoundsException e){
                        System.err.println(e.getMessage());
                    }
                }else{
                    System.err.println("Command is wrong. Try again.");
                }

            }else{
                System.out.println("exit");
                System.exit(0);
            }
       }
    }

}
