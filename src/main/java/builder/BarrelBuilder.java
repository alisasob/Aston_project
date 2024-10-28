package main.java.builder;

import main.java.entity.Barrel;

public class BarrelBuilder implements Builder<Integer, String, String> {
    private int volume;
    private String storedMaterial;
    private String ownMaterial;

    @Override
    public void setValues(Integer val1, String val2, String val3) {
        this.volume = val1;
        this.storedMaterial = val2;
        this.ownMaterial = val3;
    }

    public Barrel getResult(){
        return new Barrel(volume, storedMaterial, ownMaterial);
    }
}
