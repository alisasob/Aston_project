package main.java.input;

import java.util.ArrayList;
import main.java.entity.Sortable;

public class InputContext {
    private InputStrategy<?> strategy; // Универсальный тип для стратегии

    public void setStrategy(InputStrategy<?> strategy) {
        this.strategy = strategy;
    }

    public ArrayList<Sortable> executeStrategy(Object input) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия не установлена");
        }
        return strategy.getValues(input);
    }
}
