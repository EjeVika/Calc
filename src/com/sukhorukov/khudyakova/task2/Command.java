package com.sukhorukov.khudyakova.task2;



import java.lang.reflect.Field;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**

 */
public abstract class Command {
    private int minStackLength;
    protected Command(int minStackLength){
        this.minStackLength = minStackLength;
    }
    public final void execute(String userInput) throws NoSuchFieldException, IllegalAccessException {
        Stack<Double> st = new Stack<>();
        this.getClass().getDeclaredField("st").get(st);
        int currentStackLength = st.size();
        if (currentStackLength<minStackLength){
            throw new EmptyStackException();
        }else{
            executeImpl(userInput);
        }
    }
    protected abstract void executeImpl(String userInput);
}
