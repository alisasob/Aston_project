package main.java;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.entity.Sortable;
import main.java.input.ConsoleInput;
import main.java.input.InputContext;
import main.java.input.InputFromFile;
import main.java.input.RandomInput;
import main.java.output.OutputToFile;
import main.java.sort.InsertionEvenSort;
import main.java.sort.InsertionSort;
import main.java.sort.SortContext;
import main.java.search.BinarySearcher;

public class Main {
    public static void main(String[] args) {

        InputContext inputContext;
        SortContext sortContext = new SortContext();
        sortContext.setStrategy(new InsertionSort());

        Scanner scanner = new Scanner(System.in);
        String answer = "";
        ArrayList<Sortable> objectList = new ArrayList<>();

        while (true) {
            System.out.println("------------------------------");
            System.out.println("Menu");
            System.out.println("------------------------------");
            System.out.println("1. Input objects from console.");
            System.out.println("2. Input objects from file.");
            System.out.println("3. Generate objects randomly.");
            System.out.println("4. Print list of objects.");
            System.out.println("5. Write list of objects to the file.");
            System.out.println("6. Insertion sort.");
            System.out.println("7. Another sort.");
            System.out.println("8. Binary search.");
            System.out.println("0. Quit");
            answer = scanner.nextLine();
            switch (answer) {
                case ("1"):
                    objectList.clear();
                    inputContext = new InputContext(new ConsoleInput());
                    objectList.addAll(inputContext.inputValues());
                    break;
                case ("2"):
                    objectList.clear();
                    inputContext = new InputContext(new InputFromFile());
                    objectList.addAll(inputContext.inputValues());
                    break;
                case ("3"):
                    objectList.clear();
                    inputContext = new InputContext(new RandomInput());
                    objectList.addAll(inputContext.inputValues());
                    break;
                case ("4"):
                    if (objectList.size() == 0){
                        System.out.println("List is empty.");
                    }
                    else {
                        objectList.forEach(System.out::println);
                    }
                    break;
                case ("5"):
                    OutputToFile.out(objectList);
                    break;
                case ("6"):
                    sortContext.setStrategy(new InsertionSort());
                    sortContext.sort(objectList);
                    break;
                case ("7"):
                    sortContext.setStrategy(new InsertionEvenSort());
                    sortContext.sort(objectList);
                    break;
                case ("8"):
                    if (objectList.size() == 0){
                        System.out.println("List is empty.");
                    }
                    else {
                        int index = BinarySearcher.binarySearch(objectList, ConsoleInput.getValue());
                        if (index != -1) {
                            System.out.println("Index of the element is: " + index);
                        } else {
                            System.out.println("Nothing found.");
                        }
                    }
                    break;
                case ("0"):
                    return;
                default:
                    System.out.println("Wrong input. Try again.");
            }
        }
    }
}