package main.java.entity;

import java.util.Random;
import main.java.enums.EyeColor;
import main.java.enums.Species;
import main.java.rng.RandomEnumGenerator;

public class Animal implements Sortable{
    private final String species;
    private final String eyeColor;
    private final boolean hasHair;

    public Animal(String species, String eyeColor, boolean hasHair){
      this.species = species;
      this.eyeColor = eyeColor;
      this.hasHair = hasHair;
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isHasHair() {
        return hasHair;
    }

    public static AnimalBuilder builder(){
        return  new AnimalBuilder();
    }

    public static class AnimalBuilder{
        private String species;
        private String eyeColor;
        private boolean hasHair;

        public AnimalBuilder species(String species){
            this.species = species;
            return this;
        }

        public AnimalBuilder eyeColor(String eyeColor){
            this.eyeColor = eyeColor;
            return this;

        }public AnimalBuilder hasHair(boolean hasHair){
            this.hasHair = hasHair;
            return this;
        }

        public Animal getResult(){
            return new Animal(species, eyeColor, hasHair);
        }
    }


    public static Animal getRandom(){
        RandomEnumGenerator spe = new RandomEnumGenerator(Species.class);
        RandomEnumGenerator ec = new RandomEnumGenerator(EyeColor.class);
        Species species = (Species) spe.randomEnum();
        EyeColor eyeColor = (EyeColor) ec.randomEnum();
        Random r = new Random();
        return Animal.builder()
                     .species(species.title)
                     .eyeColor(eyeColor.title)
                     .hasHair(r.nextBoolean())
                     .getResult();
    }

    @Override
    public String toString() {
        return "Animal:species:" + getSpecies() + ":eyeColor:" + getEyeColor() + ":hasHair:" + isHasHair();
    }

    @Override
    public int compareTo(Sortable object) {
        if (object instanceof Animal) {
            // Сравнение по наличию шерсти
            if (this.hasHair && !((Animal) object).hasHair) {
                return -1; // Этот объект идет первым
            } else if (!this.hasHair && ((Animal) object).hasHair) {
                return 1; // Этот объект идет последним
            }
            // Если оба имеют или не имеют шерсть, сравниваем по виду
            return this.species.compareTo(((Animal) object).species);
        } else if (object instanceof Barrel) {
            return -1; // Animal идет перед Barrel
        } else if (object instanceof Person) {
            return -1; // Animal идет перед Person
        }
        return 0; // Неизвестный тип
    }
}
