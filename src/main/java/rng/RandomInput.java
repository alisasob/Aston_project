package main.java.rng;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;
import main.java.input.InputStrategy;

public class RandomInput implements InputStrategy{

    @Override
    public ArrayList<Sortable> getValues() {
        ArrayList<Sortable> objectList = new ArrayList<>();
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int n;
        String str;
        System.out.println("How many object do you want to create?");
        str = scanner.nextLine();
        try {
            n = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            n = 0;
        }
        while (n == 0) {
            System.out.println("Wrong input, try again.");
            str = scanner.nextLine();
            try {
                n = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                n = 0;
            }
        }
        int t;
        for (int i = 0; i < n; i++){
            t = r.nextInt(3);
            switch (t) {
                case (0):
                    Animal animal = Animal.builder().getResult();
                    objectList.add(animal.getRandom());
                    break;
                case (1):
                    Barrel barrel = Barrel.builder().getResult();
                    objectList.add(barrel.getRandom());
                    break;
                case (2):
                    Person person = Person.builder().getResult();
                    objectList.add(person.getRandom());
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

        }
        return objectList;
    }
}
