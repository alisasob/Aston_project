package main.java.sort;


import java.util.ArrayList;
import java.util.List;
import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;

public class InsertionEvenSort implements SortStrategy {
    @Override
    public void sort(List<Sortable> sortableList) {


        List<Integer> listPosition = new ArrayList<>();
        List<Sortable> listEven = new ArrayList<>();

        for(int i = 0; i < sortableList.size(); i++){
            Sortable item = sortableList.get(i);
            if (item instanceof Person) {
                if (((Person) item).getAge() % 2 == 0) {
                    listPosition.add(i);
                    listEven.add(item);
                }
            }
            else if (item instanceof Barrel) {
                if (((Barrel) item).getVolume() % 2 == 0) {
                    listPosition.add(i);
                    listEven.add(item);
                }
            }
            else if (item instanceof Animal) {
                int hairInt = ((Animal) item).isHasHair() ? 1 : 0;
                if (hairInt % 2 == 0) {
                    listPosition.add(i);
                    listEven.add(item);
                }
            }
        }

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(listEven);
        for(int i = 0; i < listPosition.size(); i++){
            sortableList.set(i, listEven.get(i));
        }
    }
}
