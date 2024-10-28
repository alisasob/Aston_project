package main.java.sort;

import java.util.List;
import main.java.entity.Sortable;

public interface SortStrategy {
    void sort(List<Sortable> array);
}
