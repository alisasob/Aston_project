package main.java.entity;

import java.util.Random;
import main.java.enums.OwnMaterial;
import main.java.enums.StoredMaterial;
import main.java.rng.RandomEnumGenerator;
public class Barrel implements Sortable {
    private final int volume;
    private final String storedMaterial;
    private final String ownMaterial;

    public Barrel(int volume, String storedMaterial, String ownMaterial){
        this.volume = volume;
        this.storedMaterial = storedMaterial;
        this.ownMaterial = ownMaterial;
    }

    public int getVolume() {
        return volume;
    }

    public String getOwnMaterial() {
        return ownMaterial;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public static BarrelBuilder builder(){
        return new BarrelBuilder();
    }

    public static class BarrelBuilder{

        private int volume;
        private String storedMaterial;
        private String ownMaterial;

        public BarrelBuilder volume(int volume){
            this.volume = volume;
            return this;
        }

        public BarrelBuilder storedMaterial(String storedMaterial){
            this.storedMaterial = storedMaterial;
            return this;

        }public BarrelBuilder ownMaterial(String ownMaterial){
            this.ownMaterial = ownMaterial;
            return this;
        }

        public Barrel getResult(){
            return new Barrel(volume, ownMaterial, storedMaterial);
        }
    }

    public Barrel getRandom(){
        RandomEnumGenerator sm = new RandomEnumGenerator(StoredMaterial.class);
        RandomEnumGenerator om = new RandomEnumGenerator(OwnMaterial.class);
        StoredMaterial storedMaterial = (StoredMaterial) sm.randomEnum();
        OwnMaterial ownMaterial = (OwnMaterial) om.randomEnum();
        Random r = new Random();
        return Barrel.builder()
                .ownMaterial(ownMaterial.title)
                .storedMaterial(storedMaterial.title)
                .volume(r.nextInt(1000 - 10) + 10)
                .getResult();
    }
    @Override
    public String toString() {
        return "Barrel:volume:" + getVolume() + ":storedMaterial:" + getStoredMaterial() + ":ownMaterial:" + getOwnMaterial();
    }

    @Override
    public int compareTo(Sortable object) {
        if (object instanceof Barrel) {
            // Сравнение по объему
            return Integer.compare(((Barrel) object).volume, this.volume); // Больший объем идет первым
        } else if (object instanceof Animal) {
            return 1; // Barrel идет после Animal
        } else if (object instanceof Person) {
            return -1; // Barrel идет перед Person
        }
        return 0; // Неизвестный тип
    }
}