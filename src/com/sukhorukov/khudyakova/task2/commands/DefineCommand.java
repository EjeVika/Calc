package com.sukhorukov.khudyakova.task2.commands;

import com.sukhorukov.khudyakova.task2.AbstractCommand;
import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;


import java.util.Map;

/**

 */
public class DefineCommand extends AbstractCommand {

    public DefineCommand() {
        super(0);
    }

    @Override
    public void executeImpl(String userInput) {
        String[] mas = userInput.split(" ");
        Double d=new Double(mas[2]);
        def.put(mas[1], d);
    }

    @In(typeArg = EnumArg.CONTEXT)
    private Map<String, Double> def;
}
