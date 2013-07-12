package com.sukhorukov.khudyakova.task2;



import com.sukhorukov.khudyakova.task2.annotation.In;
import com.sukhorukov.khudyakova.task2.commands.PrintCommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

/**

 */
public class CommandFactory {

    public CommandFactory(Stack<Double> st,Map<String,Double> def) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        try(InputStream in = CommandFactory.class.getResourceAsStream("commands.properties")){
            Properties p = new Properties();
            Reader reader1 = new InputStreamReader(in);
                p.load(reader1);
                Command anyCmd = new PrintCommand(); // load "commands" package
                commandTable = new HashMap<>();
                for (Object key:p.keySet() ) {

                    String className= p.getProperty(key.toString());
                //    System.out.println(className);
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
             //   Class cls=Class.forName("com.sukhorukov.khudyakova.task2.commands."+className);
               //     Object cmd=cls.newInstance();
               //     Command cmd1=(Command)cmd;
                    InvocationHandler handler = new MyInvocationHandler();

                    Command cmd = (Command) Proxy.newProxyInstance(cls.getClassLoader(),
                            new Class[] {Command.class},handler);


                    Command cmd1=(Command)cmd;
                    System.out.println(cmd1.getClass().getDeclaredField("cmd").getName());
                //    System.out.println(cls.toString());
                //    System.out.println(cls.getDeclaredFields()[0].getName());
                    for (Field f:cls.getDeclaredFields()){
                 //   System.out.println(f.getName());
                    //    System.out.println(f.getDeclaredAnnotations()[0].annotationType());
                    //    System.out.println(f.getAnnotation(In.class));
                    In anno = f.getAnnotation(In.class);
                //    System.out.println(anno);
                    if (anno!=null){
                        switch (anno.typeArg()){
                            case STACK: {
                              //  System.out.println("STACK");
                                f.setAccessible(true);
                                f.set(cmd1,st);
                                f.setAccessible(false);
                                break;
                            }
                            case CONTEXT:{
                            //    System.out.println("CONTEXT");
                                f.setAccessible(true);
                                f.set(cmd1,def);
                                f.setAccessible(false);
                                break;
                            }
                        }
                    }
                }
    //                InvocationHandler handler = new MyInvocationHandler();
    //                Command proxy = (Command) Proxy.newProxyInstance(Command.class.getClassLoader(),
    //                                                                    new Class[] {Command.class},handler);
                    commandTable.put(key.toString(),cmd1);
 //                 for (String s:commandTable.keySet()){
   //                   System.out.println(s+" "+commandTable.get(s));
     //           }


            }
        }

    }

    public Command getCommand(String key){

        return commandTable.get(key);
    }

    private HashMap<String,Command> commandTable;





}
