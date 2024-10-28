package main.java.builder;

import main.java.entity.Animal;

public class AnimalBuilder implements Builder<String, String, Boolean> {
    private String species;
    private String eyeColor;
    private boolean hasHair;

    @Override
    public void setValues(String val1, String val2, Boolean val3) {
        this.species = val1;
        this.eyeColor = val2;
        this.hasHair = val3;
    }

    public Animal getResult(){
        return new Animal(species, eyeColor, hasHair);
    }
}
