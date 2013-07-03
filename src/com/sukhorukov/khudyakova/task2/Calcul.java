package com.sukhorukov.khudyakova.task2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 03.07.13
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public class Calcul {

    public Calcul(InputStream inputStr) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

 // reading the table of commands
        Properties p = new Properties();
        Reader reader1 = new InputStreamReader(Main.class.getResourceAsStream("commands.properties"));
        p.load(reader1);

// initializing of stack and "define"
        Stack<Double> st = new Stack<>();
        HashMap<String,Double> def = new HashMap<>();

// reading first input

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();







    }
    public void executeCommands(){

        // main loop
        while (!(userInput.equals("quit"))){

// searching for the command in properties and command executing
            for (Object key:p.keySet() ) {
                if(userInput.split(" ")[0].equals(key.toString())){
                    String className= p.getProperty(key.toString());
                    Class cls=Class.forName("com.sukhorukov.khudyakova.task2.commands."+className);
                    Object cmd=cls.newInstance();
                    Command cmd1=(Command)cmd;
                    cmd1.execute(st,userInput,def);
                };
            }
            userInput = scan.nextLine();
        }
    }
}
