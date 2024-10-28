package main.java.input;

import java.util.ArrayList;
import main.java.entity.Sortable;

public class InputFromFile implements InputStrategy<Object> {
    @Override
    public ArrayList<Sortable> getValues(Object filePathObject) {
        ArrayList<Sortable> sortableList = new ArrayList<>();
        // Проверяем, что переданный объект является строкой
        if (filePathObject instanceof String) {
            String filePath = (String) filePathObject;
            DataLoader dataLoader = new DataLoader();
            sortableList.addAll(dataLoader.loadFromFile(filePath));
        } else {
            throw new IllegalArgumentException("Expected a String for the file path.");
        }

        return sortableList;
    }
}
