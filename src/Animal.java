import java.util.Random;

public class Animal implements Sortable {
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
