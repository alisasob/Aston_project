package main.java.sort;

import java.util.List;
import main.java.entity.Sortable;

public class SortContext {

    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Sortable> items) {
        strategy.sort(items);

    }
}
