import java.util.Random;

public class Person implements Sortable {
    private final String gender;
    private final int age;
    private final String surname;

    public Person(String gender, int age, String surname){
        this.gender = gender;
        this.age = age;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSurname() {
        return surname;
    }

    public static Person getRandom(){
        RandomEnumGenerator gen = new RandomEnumGenerator(Gender.class);
        Gender gender = (Gender) gen.randomEnum();
        Random r = new Random();

        if (gender.title.equals("male")){
            RandomEnumGenerator sur = new RandomEnumGenerator(MSurname.class);
            MSurname surname = (MSurname) sur.randomEnum();
            return new Person(gender.title, r.nextInt(150), surname.title);
        } else {
            RandomEnumGenerator sur = new RandomEnumGenerator(FSurname.class);
            FSurname surname = (FSurname) sur.randomEnum();
            return new Person(gender.title, r.nextInt(150), surname.title);
        }
    }
    @Override
    public String toString() {
        return "Person:gender:" + getGender() + ":age:" + getAge() + ":surname:" + getSurname();
    }

    @Override
    public int compareTo(Sortable object) {
        if (object instanceof Person) {
            // Сравнение по возрасту
            return Integer.compare(((Person) object).age, this.age); // Старший идет первым
        } else if (object instanceof Animal) {
            return 1; // Person идет после Animal
        } else if (object instanceof Barrel) {
            return 1; // Person идет после Barrel
        }
        return 0; // Неизвестный тип
    }
}
