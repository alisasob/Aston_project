package main.java.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.java.entity.Animal;
import main.java.entity.Barrel;
import main.java.entity.Person;
import main.java.entity.Sortable;

public class InputFromFile implements InputStrategy{
    @Override
    public ArrayList<Sortable> getValues() {

        ArrayList<Sortable> objectList = new ArrayList<>();
        String filePath = "src/main/resources/Collection.txt";
        File file = new File(filePath);

        try{
            Scanner scanner = new Scanner(file);
            List<String> stringList = new ArrayList<>();
            while (scanner.hasNextLine()){
                stringList.add(scanner.nextLine());
            }
            if (stringList.size() == 0){
                System.out.println("File is empty");
                return objectList;
            }
            String[] temp;
            for (String string : stringList){
                temp = string.split(":");
                if (temp.length == 7) {
                    //System.out.println(Arrays.toString(temp));
                    //System.out.println(temp.length);
                    //System.out.println(temp[0]);
                    if (temp[0].equals("Animal") && Checker.checkAnimal(temp)) {
                        objectList.add(Animal.builder()
                                             .species(temp[2])
                                             .eyeColor(temp[4])
                                             .hasHair(Boolean.parseBoolean(temp[6]))
                                             .getResult());
                        //System.out.println(ab.getResult());
                    } else if (temp[0].equals("Barrel") && Checker.checkBarrel(temp)) {
                        objectList.add(Barrel.builder()
                                             .volume(Integer.parseInt(temp[2]))
                                             .storedMaterial(temp[4])
                                             .ownMaterial(temp[6])
                                             .getResult());
                        //System.out.println(bb.getResult());
                    } else if (temp[0].equals("Person") && Checker.checkPerson(temp)) {
                        objectList.add(Person.builder()
                                             .gender(temp[2])
                                             .age(Integer.parseInt(temp[4]))
                                             .surname(temp[6])
                                             .getResult());
                        //System.out.println(pb.getResult());
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        //stringList.stream().forEach(System.out::println);
        if (objectList.size() == 0){
            System.out.println("Could not input anything. Wrong data format.");
        }
        return objectList;
    }
}
