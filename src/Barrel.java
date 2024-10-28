import java.util.Random;

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

    public static Barrel getRandom(){
        RandomEnumGenerator sm = new RandomEnumGenerator(StoredMaterial.class);
        RandomEnumGenerator om = new RandomEnumGenerator(OwnMaterial.class);
        StoredMaterial storedMaterial1 = (StoredMaterial) sm.randomEnum();
        OwnMaterial ownMaterial1 = (OwnMaterial) om.randomEnum();
        Random r = new Random();
        return new Barrel(r.nextInt(1000 - 10) + 10, storedMaterial1.title, ownMaterial1.title);
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
