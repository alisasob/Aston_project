import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) /*throws FileNotFoundException*/ {
//        AnimalBuilder ab = new AnimalBuilder();
//        ab.setValues("cat", "green", true);
//        Animal a = ab.getResult();
//        BarrelBuilder bb = new BarrelBuilder();
//        bb.setValues(10, "oil", "metal");
//        Barrel b = bb.getResult();
//        PersonBuilder pb = new PersonBuilder();
//        pb.setValues("male", 22, "Ivanov");
//        Person p = pb.getResult();
        //Stream.of(a, b, p).forEach(x->System.out.println(x.toString()));


        ArrayList<Object> objectList;
//        File file = new File("Collection.txt");
//        InputFromFile fInput = new InputFromFile();
//        objectList = fInput.getValues(file);
//        objectList.stream().forEach(x -> System.out.println(x.getClass()));

//        System.out.println(Animal.getRandom());
//        System.out.println(Animal.getRandom());
//        System.out.println(Animal.getRandom());
//        System.out.println(Barrel.getRandom());
//        System.out.println(Barrel.getRandom());
//        System.out.println(Barrel.getRandom());
//        System.out.println(Person.getRandom());
//        System.out.println(Person.getRandom());
//        System.out.println(Person.getRandom());

        RandomInput rInput = new RandomInput();
        objectList = rInput.getValues(10);
        objectList.stream().forEach(x -> System.out.println(x));
        //System.out.println(objectList);

    }


}