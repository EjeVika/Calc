package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.AbstractCommand;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.util.Map;
import java.util.Stack;

/**

 */
public class PushCommand extends AbstractCommand {


    public PushCommand() {
        super(0);
    }

    @Override
    public void executeImpl(String userInput) {
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

            if (flag){
                st.push(pushValue);
            }else {
                st.push(new Double(mas[1]) );
            }
        }catch (NumberFormatException e ){
            throw new NumberFormatException("The parameter \""+mas[1]+"\" is not defined" );
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("Number of arguments of PUSH command is wrong");
        }
    }

    @In(typeArg = EnumArg.STACK)
    private Stack<Double> st;
    @In (typeArg = EnumArg.CONTEXT)
    private Map<String, Double> def;
}
