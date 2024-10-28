package main.java.entity;

import java.util.Random;
import main.java.enums.FSurname;
import main.java.enums.Gender;
import main.java.enums.MSurname;
import main.java.rng.RandomEnumGenerator;

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
        RandomEnumGenerator<Gender> gen = new RandomEnumGenerator<>(Gender.class);
        RandomEnumGenerator<FSurname> femaleSurname = new RandomEnumGenerator<>(FSurname.class);
        RandomEnumGenerator<MSurname> maleSurname = new RandomEnumGenerator<>(MSurname.class);

        Gender gender = gen.randomEnum();
        Random r = new Random();

        if (gender.title.equals("male")){
            MSurname surname = maleSurname.randomEnum();
            return new Person(gender.title, r.nextInt(150), surname.title);
        } else {
            FSurname surname = femaleSurname.randomEnum();
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
            return 1; // main.java.entity.Person идет после main.java.entity.Animal
        } else if (object instanceof Barrel) {
            return 1; // main.java.entity.Person идет после main.java.entity.Barrel
        }
        return 0; // Неизвестный тип
    }
}
