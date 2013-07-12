package com.sukhorukov.khudyakova.task2;



import java.util.EmptyStackException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**

 */
public class Calcul {

    public Calcul(Stack<Double> st,Map<String,Double> def){
            this.stack = st;
            this.define = def;
    }
    public void executeCalculations(Scanner scan,CommandFactory cmdFactory){

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
    public Stack<Double> getStack(){
          return stack;
    }

    private Stack<Double> stack;
    private Map<String,Double> define;
}
