package com.sukhorukov.khudyakova.task2;



import com.sukhorukov.khudyakova.task2.annotation.In;
import com.sukhorukov.khudyakova.task2.commands.PrintCommand;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

/**

 */
public class CommandFactory {
    private static final Logger log = Logger.getLogger(CommandFactory.class);
    public CommandFactory(Stack<Double> st,Map<String,Double> def) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        try(InputStream in = CommandFactory.class.getResourceAsStream("commands.properties")){
            Properties p = new Properties();
            Reader reader1 = new InputStreamReader(in);
            p.load(reader1);
            Command anyCmd = new PrintCommand(); /* load any command from "commands" package
                                                    in order to let ClassLoader know about it */
            commandTable = new HashMap<>();
            for (Object key:p.keySet() ) {

                String className= p.getProperty(key.toString());
                log.debug(className);
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

                for (Field f:cls.getDeclaredFields()){
                    log.debug(f.getName());
                    In anno = f.getAnnotation(In.class);
                    log.debug(anno);
                    if (anno!=null){
                        switch (anno.typeArg()){
                            case STACK: {
                                log.debug("STACK");
                                f.setAccessible(true);
                                f.set(cmd1,st);
                                f.setAccessible(false);
                                break;
                            }
                            case CONTEXT:{
                                log.debug("CONTEXT");
                                f.setAccessible(true);
                                f.set(cmd1,def);
                                f.setAccessible(false);
                                break;
                            }
                        }
                    }
                }

                InvocationHandler handler = new MyInvocationHandler(cmd1,st,def);
                Command cmd2 = (Command) Proxy.newProxyInstance(cls.getClassLoader(),
                                new Class[] {Command.class},handler);
                commandTable.put(key.toString(),cmd2);

            }
        }
    }

    public Command getCommand(String key){
        return commandTable.get(key);
    }

    public Set<String> getKeySet() {
        return commandTable.keySet();
    }

    private HashMap<String,Command> commandTable;
}
