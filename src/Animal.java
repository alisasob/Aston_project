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


    public Animal getRandom(){
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
}
