package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;
import main.java.input.ConsoleInput;
import main.java.input.InputContext;
import main.java.input.InputFromFile;
import main.java.rng.RandomInput;
import main.java.output.OutputToFile;

//import main.java.sort.InsertionSort;
public class Main {
    public static void main(String[] args) /*throws FileNotFoundException*/ {
        InputContext inputContext;
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        ArrayList<Object> objectList = new ArrayList<>();
        while (!answer.equals("0")) {
            System.out.println("------------------------------");
            System.out.println("Menu");
            System.out.println("------------------------------");
            System.out.println("1. Input objects from console.");
            System.out.println("2. Input objects from file.");
            System.out.println("3. Generate objects randomly.");
            System.out.println("4. Print list of objects.");
            System.out.println("5. Write list of objects to the file.");
            System.out.println("0. Quit");
            answer = scanner.nextLine();
            switch (answer) {
                case ("1"):
                    inputContext = new InputContext(new ConsoleInput());
                    objectList.addAll(inputContext.inputValues());
                    break;
                case ("2"):
                    inputContext = new InputContext(new InputFromFile());
                    objectList.addAll(inputContext.inputValues());
                    break;
                case ("3"):
                    inputContext = new InputContext(new RandomInput());
                    objectList.addAll(inputContext.inputValues());
                    break;
                case ("4"):
                    if (objectList.size() == 0){
                        System.out.println("List is empty.");
                    }else {
                        objectList.forEach(System.out::println);
                    }
                    break;
                case ("5"):
                    OutputToFile.out(objectList);
                    break;
                case ("0"):
                    return;
                default:
                    System.out.println("Wrong input. Try again.");
            }

        }

    }

//        AnimalBuilder ab = new AnimalBuilder();
//        ab.setValues("cat", "green", true);
//        Animal a = ab.getResult();
//        BarrelBuilder bb = new BarrelBuilder();
//        bb.setValues(10, "oil", "metal");
//        Barrel b = bb.getResult();
//        PersonBuilder pb = new PersonBuilder();
//        pb.setValues("male", 22, "Ivanov");
//        Person p = pb.getResult();
//        Stream.of(a, b, p).forEach(x->System.out.println(x.toString()));




//        ArrayList<Object> objectList;
//        File file = new File("Collection.txt");
//        InputFromFile fInput = new InputFromFile();
//        objectList = fInput.getValues();
//        objectList.stream().forEach(x -> System.out.println(x));

//        ArrayList<Object> objectList;
//        ConsoleInput cInput = new ConsoleInput();
//        objectList = cInput.getValues();
//        objectList.stream().forEach(x -> System.out.println(x));

//        System.out.println(Animal.getRandom());
//        System.out.println(Animal.getRandom());
//        System.out.println(Animal.getRandom());
//        System.out.println(Barrel.getRandom());
//        System.out.println(Barrel.getRandom());
//        System.out.println(Barrel.getRandom());
//        System.out.println(Person.getRandom());
//        System.out.println(Person.getRandom());
//        System.out.println(Person.getRandom());


//        System.out.println(Person.builder().getResult().getRandom());

    //System.out.println(objectList);

}