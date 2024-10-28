import main.java.entity.Sortable;

import java.util.ArrayList;

public class InsertionSorted {
    public static void insertionSort(ArrayList<Sortable> items) {
        for (int i = 1; i < items.size(); i++) {
            Sortable key = items.get(i);
            int j = i - 1;

            while (j >= 0 && items.get(j).compareTo(key) > 0) {
                items.set(j + 1, items.get(j));
                j--;
            }
            items.set(j + 1, key);
        }
    }
}
