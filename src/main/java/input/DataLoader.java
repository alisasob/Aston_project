package main.java.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;

public class DataLoader {

    public List<Sortable> loadFromFile(String filePath) {
        List<Sortable> sortableList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length < 2) continue;

                switch (parts[0]) {
                    case "Animal":
                        sortableList.add(createAnimal(parts));
                        break;
                    case "Barrel":
                        sortableList.add(createBarrel(parts));
                        break;
                    case "Person":
                        sortableList.add(createPerson(parts));
                        break;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }

        return sortableList;
    }

    private Animal createAnimal(String[] parts) {
        String species = parts[2];
        String eyeColor = parts[4];
        boolean hasHair = Boolean.parseBoolean(parts[6]);
        return new Animal(species, eyeColor, hasHair);
    }

    private Barrel createBarrel(String[] parts) {
        int volume = Integer.parseInt(parts[2]);
        String storedMaterial = parts[4];
        String ownMaterial = parts[6];
        return new Barrel(volume, storedMaterial, ownMaterial);
    }

    private Person createPerson(String[] parts) {
        String gender = parts[2];
        int age = Integer.parseInt(parts[4]);
        String surname = parts[6];
        return new Person(gender, age, surname);
    }
}