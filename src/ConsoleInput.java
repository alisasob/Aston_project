import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleInput implements InputStrategy{

    @Override
    public ArrayList<Object> getValues() {
        ArrayList<Object> objectList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num;
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
        while (n == 0){
            System.out.println("Wrong input, try again.");
            str = scanner.nextLine();
            try {
                n = Integer.parseInt(str);
            }
            catch (NumberFormatException e) {
                n = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("What object do you want to create?");
            System.out.println("1. Animal");
            System.out.println("2. Barrel");
            System.out.println("3. Person");
            System.out.println("Please input a number:");
            str = scanner.nextLine();
            try {
                num = Integer.parseInt(str);
            }
            catch (NumberFormatException e) {
                num = 0;
            }
            num = (num != 1 && num != 2 && num != 3) ? 0 : num;
            while (num == 0){
                System.out.println("Wrong input, try again.");
                str = scanner.nextLine();
                try {
                    num = Integer.parseInt(str);
                    num = (num != 1 && num != 2 && num != 3) ? 0 : num;
                }
                catch (NumberFormatException e) {
                    num = 0;
                }
            }
            switch (num){
                case (1):
                    System.out.println("Animal:");
                    System.out.println("Species:");
                    str = scanner.nextLine();
                    while (!Checker.checkName(str)){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    String species = str;
                    System.out.println("Eye color:");
                    str = scanner.nextLine();
                    while (!Checker.checkName(str)){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    String eyeColor = str;
                    System.out.println("Does it have hair? (yes or no):");
                    str = scanner.nextLine();
                    while (!(str.equalsIgnoreCase("yes"))
                            && !(str.equalsIgnoreCase("no"))){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    boolean hasHair = str.equalsIgnoreCase("yes");
                    objectList.add(Animal.builder()
                                         .species(species)
                                         .eyeColor(eyeColor)
                                         .hasHair(hasHair)
                                         .getResult());
                    break;
                case (2):
                    System.out.println("Barrel:");
                    System.out.println("Volume:");
                    str = scanner.nextLine();
                    int volume;
                    try {
                        volume = Integer.parseInt(str);
                    }
                    catch (NumberFormatException e) {
                        volume = 0;
                    }
                    while (volume == 0){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                        try {
                            volume = Integer.parseInt(str);
                        }
                        catch (NumberFormatException e) {
                            volume = 0;
                        }
                    }
                    System.out.println("Stored material:");
                    str = scanner.nextLine();
                    while (!Checker.checkName(str)){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    String storedMaterial = str;
                    System.out.println("Own material:");
                    str = scanner.nextLine();
                    while (!Checker.checkName(str)){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    String ownMaterial = str;
                    objectList.add(Barrel.builder()
                                         .volume(volume)
                                         .ownMaterial(ownMaterial)
                                         .storedMaterial(storedMaterial)
                                         .getResult());
                    break;
                case (3):
                    System.out.println("Person:");
                    System.out.println("Gender (male or female):");
                    str = scanner.nextLine();
                    while (!(str.equalsIgnoreCase("male"))
                            && !(str.equalsIgnoreCase("female"))){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    String gender = str.toLowerCase();
                    System.out.println("Age:");
                    int age;
                    str = scanner.nextLine();
                    try {
                        age = Integer.parseInt(str);
                    }
                    catch (NumberFormatException e) {
                        age = -1;
                    }
                    while (age == -1){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                        try {
                            age = Integer.parseInt(str);
                        }
                        catch (NumberFormatException e) {
                            age = -1;
                        }
                    }
                    System.out.println("Surname:");
                    str = scanner.nextLine();
                    while (!Checker.checkName(str)){
                        System.out.println("Wrong input, try again.");
                        str = scanner.nextLine();
                    }
                    String surname = str.toLowerCase();
                    String f = "" + surname.charAt(0);
                    surname = f + surname.substring(1);
                    objectList.add(Person.builder()
                                         .age(age)
                                         .surname(surname)
                                         .gender(gender)
                                         .getResult());
                    break;
            }
        }
        return objectList;
    }
}
