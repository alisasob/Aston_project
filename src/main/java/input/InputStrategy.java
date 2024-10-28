package main.java.input;

import java.util.ArrayList;

public interface InputStrategy<T>{
    ArrayList<Object> getValues(T t);
}
