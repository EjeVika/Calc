package com.sukhorukov.khudyakova.task2;


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

        try(InputStream in = Main.class.getResourceAsStream("commands.properties")){
            Properties p = new Properties();
            Reader reader1 = new InputStreamReader(in);
            p.load(reader1);
            commandTable = new HashMap<>();
            for (Object key:p.keySet() ) {

                String className= p.getProperty(key.toString());
                Class cls=Class.forName("com.sukhorukov.khudyakova.task2.commands."+className);
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
