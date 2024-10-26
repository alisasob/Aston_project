import java.util.Random;

public class Animal {
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

    public static Animal getRandom(){
        RandomEnumGenerator spe = new RandomEnumGenerator(Species.class);
        RandomEnumGenerator ec = new RandomEnumGenerator(EyeColor.class);
        Species species = (Species) spe.randomEnum();
        EyeColor eyeColor = (EyeColor) ec.randomEnum();
        Random r = new Random();
        return new Animal(species.title, eyeColor.title, r.nextBoolean());
    }

    @Override
    public String toString() {
        return "Animal:species:" + getSpecies() + ":eyeColor:" + getEyeColor() + ":hasHair:" + isHasHair();
    }
}
