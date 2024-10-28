package main.java;

import java.util.List;
import java.util.Scanner;
import main.java.entity.Sortable;
import main.java.input.InputContext;
import main.java.input.InputFromFile;
import main.java.input.RandomInput;
import main.java.sort.InsertionSort;
import main.java.sort.SortContext;

public class Main {
    public static void main(String[] args) {
        InputContext inputContext = new InputContext();
        SortContext sortContext = new SortContext();

        List<Sortable> items;
        sortContext.setStrategy(new InsertionSort());

        while(true) {

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    inputContext.setStrategy(new RandomInput());
                    items = inputContext.executeStrategy(5);

                    sortContext.sort(items);

                    for (Sortable item : items) {
                        System.out.println(item);
                    }
                    break;
                case 2:
                    inputContext.setStrategy(new InputFromFile());

                    String filePath = "src/main/resources/Collection.txt";
                    items = inputContext.executeStrategy(filePath);

                    sortContext.sort(items);

                    for (Sortable item : items) {
                        System.out.println(item);
                    }
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    input.close();
                    return;
            }
        }
    }
}