package main.java.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import main.java.entity.Sortable;
import java.util.ArrayList;
import java.util.Scanner;

public class OutputToFile {
    public static void out(ArrayList<Sortable> objectList) {
        System.out.println("Input name of file:");
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();
        String filePath = "src/main/resources/";
        try{
            File file = new File(filePath + fileName + ".txt");
            if (!file.exists()){
                file.createNewFile();
                System.out.println("New file created!");
            }
            FileWriter fw = new FileWriter(file, true);
            //objectList.forEach(System.out::println);
            objectList.forEach(x-> {
                try {
                    fw.write(x.toString() + "\n");
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }
            });
            fw.close();
            System.out.println("Written successfully!");
        } catch (IOException e){
            System.out.println("Error" + e);
        }
    }
}
