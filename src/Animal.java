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

    @Override
    public String toString() {
        return "[" + getSpecies() + ", " + getEyeColor() + ", " + isHasHair() + "]";
    }
}
