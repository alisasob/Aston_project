package main.java.input;

import java.util.ArrayList;
import java.util.Random;
import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;

public class RandomInput implements InputStrategy<Integer> {

    @Override
    public ArrayList<Sortable> getValues(Object n) {
        ArrayList<Sortable> objectList = new ArrayList<>();
        Random r = new Random();
        int t;
        for (int i = 0; i < (Integer) n; i++){
            t = r.nextInt(3);
            switch (t) {
                case (0) -> objectList.add(Animal.getRandom());
                case (1) -> objectList.add(Barrel.getRandom());
                case (2) -> objectList.add(Person.getRandom());
                default -> System.out.println("Error");
            }

        }
        return objectList;
    }
}