package com.sukhorukov.khudyakova.task2;


import com.sukhorukov.khudyakova.task2.commands.PrintCommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;

/**

 */
public class CommandFactory {

    public CommandFactory() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        try(InputStream in = CommandFactory.class.getResourceAsStream("commands.properties")){
            Properties p = new Properties();
            Reader reader1 = new InputStreamReader(in);
            p.load(reader1);
            Command anyCmd = new PrintCommand(); // load "commands" package
            commandTable = new HashMap<>();
            for (Object key:p.keySet() ) {

                String className= p.getProperty(key.toString());

                StringBuilder packageName = new StringBuilder("");
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
                Class cls=Class.forName(packageName.toString()+"."+className);
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
