package com.sukhorukov.khudyakova.task2;


//import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.commands.In;
import com.sukhorukov.khudyakova.task2.commands.PrintCommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import static com.sukhorukov.khudyakova.task2.annotation.EnumArg.*;

/**

 */
public class CommandFactory {

    public CommandFactory(Stack<Double> st,Map<String,Double> def) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        try(InputStream in = CommandFactory.class.getResourceAsStream("commands.properties")){
            Properties p = new Properties();
            Reader reader1 = new InputStreamReader(in);
            p.load(reader1);
            Command anyCmd = new PrintCommand(); // load "commands" package
            commandTable = new HashMap<>();
            for (Object key:p.keySet() ) {

                String className= p.getProperty(key.toString());

            /*    StringBuilder packageName = new StringBuilder("");
                Package[] packs = Package.getPackages();
                for (Package pck :packs){
                    String fullClassName = pck.getName()+"."+className;
                    try{
                       Class.forName(fullClassName);
                    }catch(ClassNotFoundException e){
                        continue;
                    }
                    packageName = packageName.append(pck.getName().toCharArray());
                    break;
                }
                Class cls=Class.forName(packageName.toString()+"."+className);             */
                Class cls=Class.forName("com.sukhorukov.khudyakova.task2.commands."+className);

                for (Field f:cls.getFields()){
                    In anno = f.getAnnotation(In.class);
                    if (anno!=null){
                        switch (anno.typeArg()){
                            case STACK: {
                                f.setAccessible(true);
                                f=st;
                                                       }
                        }
                        anno.typeArg()
                    }

                }
                Object cmd=cls.newInstance();
                Command cmd1=(Command)cmd;
                commandTable.put(key.toString(),cmd1);

            }
        }

    }

    public Command getCommand(String key){

        return commandTable.get(key);
    }

    private HashMap<String,Command> commandTable;





}
