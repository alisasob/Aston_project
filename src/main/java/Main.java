package main.java;

import java.util.ArrayList;
import java.util.List;
import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;
import main.java.sort.InsertionSort;

public class Main {
    public static void main(String[] args) /*throws FileNotFoundException*/ {
//        main.java.builder.AnimalBuilder ab = new main.java.builder.AnimalBuilder();
//        ab.setValues("cat", "green", true);
//        main.java.entity.Animal a = ab.getResult();
//        main.java.builder.BarrelBuilder bb = new main.java.builder.BarrelBuilder();
//        bb.setValues(10, "oil", "metal");
//        main.java.entity.Barrel b = bb.getResult();
//        main.java.builder.PersonBuilder pb = new main.java.builder.PersonBuilder();
//        pb.setValues("male", 22, "Ivanov");
//        main.java.entity.Person p = pb.getResult();
        //Stream.of(a, b, p).forEach(x->System.out.println(x.toString()));


        List<Sortable> items = new ArrayList<>();

        items.add(new Animal("Cat", "Green", true));
        items.add(new Barrel(50, "Water", "Wood"));
        items.add(new Person("Female", 40, "Smith"));
        items.add(new Animal("Dog", "Brown", false));
        items.add(new Barrel(30, "Oil", "Metal"));
        items.add(new Animal("Cat", "Green", false));
        items.add(new Barrel(49, "Water", "Wood"));
        items.add(new Barrel(50, "Water", "Wood"));
        items.add(new Barrel(40, "Water", "Wood"));
        items.add(new Barrel(35, "Water", "Wood"));
        items.add(new Person("Female", 5, "Smith"));
        items.add(new Person("Female", 7, "Smith"));
        items.add(new Person("Female", 3, "Smith"));
        items.add(new Animal("Dog", "Brown", true));
        items.add(new Barrel(30, "Oil", "Metal"));
        items.add(new Animal("Cat", "Green", true));
        items.add(new Barrel(11, "Water", "Wood"));
        items.add(new Person("Female", 10, "Smith"));
        items.add(new Animal("Dog", "Brown", true));
        items.add(new Barrel(1, "Oil", "Metal"));

        InsertionSort.insertionSort(items);
        //InsertionSortPlus.customSort(items);

        for (Sortable item : items) {
            System.out.println(item);
        }

//        File file = new File("Collection.txt");
//        main.java.input.InputFromFile fInput = new main.java.input.InputFromFile();
//        objectList = fInput.getValues(file);
//        objectList.stream().forEach(x -> System.out.println(x.getClass()));

//        System.out.println(main.java.entity.Animal.getRandom());
//        System.out.println(main.java.entity.Animal.getRandom());
//        System.out.println(main.java.entity.Animal.getRandom());
//        System.out.println(main.java.entity.Barrel.getRandom());
//        System.out.println(main.java.entity.Barrel.getRandom());
//        System.out.println(main.java.entity.Barrel.getRandom());
//        System.out.println(main.java.entity.Person.getRandom());
//        System.out.println(main.java.entity.Person.getRandom());
//        System.out.println(main.java.entity.Person.getRandom());

//        main.java.rng.RandomInput rInput = new main.java.rng.RandomInput();
//        objectList = rInput.getValues(10);
//        objectList.stream().forEach(x -> System.out.println(x));
//        //System.out.println(objectList);

    }


}