package com.sukhorukov.khudyakova.task2;



import java.util.EmptyStackException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**

 */
public class Calcul {

    public void executeCalculations(Scanner scan,CommandFactory cmdFactory,Stack<Double> st,Map<String,Double> def){



       while (scan.hasNextLine()){
            String userInput = scan.nextLine();
            if (!userInput.equals("quit")){
                String key=userInput.split(" ")[0];
                try{
                    cmdFactory.getCommand(key).execute(userInput);
                }catch(EmptyStackException e){
                    System.err.println("Stack doesn't contain enough elements");
                }catch (NumberFormatException e){
                        System.err.println(e.getMessage());
                }catch (ArrayIndexOutOfBoundsException e){
                    System.err.println(e.getMessage());
                }


            }else{
                System.out.println("exit");
                System.exit(0);
            }

       }
    }

}
