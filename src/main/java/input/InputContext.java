package main.java.input;

import main.java.entity.Sortable;

import java.util.ArrayList;

public class InputContext {
    private InputStrategy context;
    public InputContext(InputStrategy context){
        this.context = context;
    }

    public ArrayList<Sortable> inputValues(){
        return context.getValues();
    }
}
