package main.java.entity;

import java.util.Random;
import main.java.enums.OwnMaterial;
import main.java.enums.StoredMaterial;
import main.java.rng.RandomEnumGenerator;

public class Barrel implements Sortable {
    private final int volume;
    private final String storedMaterial;
    private final String ownMaterial;

    public Barrel(int volume, String ownMaterial, String storedMaterial){
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
        RandomEnumGenerator<StoredMaterial> sm = new RandomEnumGenerator<>(StoredMaterial.class);
        RandomEnumGenerator<OwnMaterial> om = new RandomEnumGenerator<>(OwnMaterial.class);
        StoredMaterial storedMaterial = sm.randomEnum();
        OwnMaterial ownMaterial = om.randomEnum();
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
            int t;
            // Сравнение по объему
            t = Integer.compare(((Barrel) object).volume, this.volume); // Больший объем идет первым
            if (t != 0) {
                return t;
            }
            // сравнение по материалу, из которого изготовлена
            t = this.ownMaterial.toLowerCase().compareTo(((Barrel) object).ownMaterial.toLowerCase());
            if (t != 0) {
                return t;
            }// сравнение по хранимому материалу
            t = this.storedMaterial.toLowerCase().compareTo(((Barrel) object).storedMaterial.toLowerCase());
            return t;
        } else if (object instanceof Animal) {
            return 1; // Barrel идет после Animal
        } else if (object instanceof Person) {
            return -1; // Barrel идет перед Person
        }
        return 0; // Неизвестный тип
    }
}