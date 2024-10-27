import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) /*throws FileNotFoundException*/ {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        ArrayList<Object> objectList = new ArrayList<>();
        while (!answer.equals("0")) {
            System.out.println("Menu");
            System.out.println("1. Input objects from console.");
            System.out.println("2. Input objects from file.");
            System.out.println("3. Generate objects randomly.");
            System.out.println("4. Print list of objects.");
            System.out.println("0. Quit");
            answer = scanner.nextLine();
            switch (answer) {
                case ("1"):
                    ConsoleInput consoleInput = new ConsoleInput();
                    objectList.addAll(consoleInput.getValues());
                    break;
                case ("2"):
                    InputFromFile inputFromFile = new InputFromFile();
                    objectList.addAll(inputFromFile.getValues());
                    break;
                case ("3"):
                    RandomInput randomInput = new RandomInput();
                    objectList.addAll(randomInput.getValues());
                    break;
                case ("4"):
                    if (objectList.size() == 0){
                        System.out.println("List is empty.");
                    }else {
                        objectList.stream().forEach(System.out::println);
                    }
                    break;
                case ("0"):
                    return;
                default:
                    System.out.println("Wrong input. try again.");
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