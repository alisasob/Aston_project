import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) /*throws FileNotFoundException*/ {
        AnimalBuilder ab = new AnimalBuilder();
        ab.setValues("cat", "green", true);
        Animal a = ab.getResult();
        BarrelBuilder bb = new BarrelBuilder();
        bb.setValues(10, "oil", "metal");
        Barrel b = bb.getResult();
        PersonBuilder pb = new PersonBuilder();
        pb.setValues("male", 22, "Ivanov");
        Person p = pb.getResult();
        //Stream.of(a, b, p).forEach(x->System.out.println(x.toString()));

        try {
            File file = new File("Collection.txt");
            Scanner scanner = new Scanner(file);
            List<Object> objectList = new ArrayList<>();
            List<String> stringList = new ArrayList<>();
            while (scanner.hasNextLine()){
                stringList.add(scanner.nextLine());
            }
            String[] temp;
            for (String string : stringList){
                temp = string.split(":");
                if (temp.length != 7){
                    System.out.println("Invalid data format");
                    break;
                }
                //System.out.println(Arrays.toString(temp));
                //System.out.println(temp.length);
                //System.out.println(temp[0]);
                if (checkAnimal(temp)) {
                    ab.setValues(temp[2], temp[4], Boolean.parseBoolean(temp[6]));
                    System.out.println(ab.getResult());
                }
                else if (checkBarrel(temp)) {
                    bb.setValues(Integer.valueOf(temp[2]), temp[4], temp[6]);
                    System.out.println(bb.getResult());
                }
                else if (checkPerson(temp)) {
                    pb.setValues(temp[2], Integer.valueOf(temp[4]), temp[6]);
                    System.out.println(pb.getResult());
                }
            }
            //stringList.stream().forEach(System.out::println);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static boolean checkAnimal (String[] a){
        if (a[0].equals("Animal") && a[1].equals("species")
                && a[3].equals("eyeColor") && a[5].equals("hasHair")){
            if (checkName(a[2]) && checkName(a[4])
                    && (a[6].equals("true") || a[6].equals("false"))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean checkBarrel (String[] b){
        if (b[0].equals("Barrel") && b[1].equals("volume")
                && b[3].equals("storedMaterial") && b[5].equals("ownMaterial")){
            if (checkName(b[4]) && checkName(b[6])) {
                try {
                    if (Integer.parseInt(b[2]) >= 0){
                        return true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e){
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean checkPerson (String[] p){
        if (p[0].equals("Person") && p[1].equals("gender")
                && p[3].equals("age") && p[5].equals("surname")){
            if (checkName(p[2]) && checkName(p[6])) {
                try {
                    if (Integer.parseInt(p[4]) >= 0 && Integer.parseInt(p[4]) <= 150){
                        return true;
                    } else {
                        System.out.println("its age");
                        return false;
                    }
                } catch (NumberFormatException e){
                    System.out.println("its catch");
                    return false;
                }
            } else {
                System.out.println("its name");
                return false;
            }
        } else {
            System.out.println("its person");
            return false;
        }
    }

    private static boolean checkName (String s){
        for (Character c : s.toCharArray()){
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

}