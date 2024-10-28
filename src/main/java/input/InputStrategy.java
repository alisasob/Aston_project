package main.java.input;

import java.util.ArrayList;
import main.java.entity.Sortable;

public interface InputStrategy<T>{
    ArrayList<Sortable> getValues(Object t);
}
