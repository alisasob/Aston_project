import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFromFile implements InputStrategy <File>{
    @Override
    public ArrayList<Object> getValues(File file) {
        AnimalBuilder ab = new AnimalBuilder();
        BarrelBuilder bb = new BarrelBuilder();
        PersonBuilder pb = new PersonBuilder();
        ArrayList<Object> objectList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
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
                if (Checker.checkAnimal(temp)) {
                    ab.setValues(temp[2], temp[4], Boolean.parseBoolean(temp[6]));
                    objectList.add(ab.getResult());
                    //System.out.println(ab.getResult());
                }
                else if (Checker.checkBarrel(temp)) {
                    bb.setValues(Integer.valueOf(temp[2]), temp[4], temp[6]);
                    objectList.add(bb.getResult());
                    //System.out.println(bb.getResult());
                }
                else if (Checker.checkPerson(temp)) {
                    pb.setValues(temp[2], Integer.valueOf(temp[4]), temp[6]);
                    objectList.add(pb.getResult());
                    //System.out.println(pb.getResult());
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //stringList.stream().forEach(System.out::println);
        return objectList;
    }
}
