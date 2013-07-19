package com.sukhorukov.khudyakova.task2;

import com.sukhorukov.khudyakova.task2.annotation.EnumArg;
import com.sukhorukov.khudyakova.task2.annotation.In;

import java.lang.reflect.Field;
import java.util.EmptyStackException;
import java.util.Stack;

/**

 */
public abstract class AbstractCommand implements Command {


        private final int minStackLength;
        protected AbstractCommand(int minStackLength){
            this.minStackLength = minStackLength;
        }
        public final void execute(String userInput) throws IllegalAccessException {
            Stack<Double> st = new Stack<>();
            int currentStackLength = 0;
            for (Field f:this.getClass().getDeclaredFields()){
                if (f.getAnnotation(In.class).typeArg().equals(EnumArg.STACK)){
                    f.setAccessible(true);
                    st = (Stack<Double>)f.get(this);
                    currentStackLength = st.size();
                    f.setAccessible(false);
                    break;
                }
            }

            if (currentStackLength<minStackLength){
                throw new EmptyStackException();
            }else{
                executeImpl(userInput);
            }
        }
        protected abstract void executeImpl(String userInput);
    }
