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

    public static PersonBuilder builder(){
        return  new PersonBuilder();
    }

    public static class PersonBuilder{

        private String gender;
        private int age;
        private String surname;

        public PersonBuilder gender(String gender){
            this.gender = gender;
            return this;
        }

        public PersonBuilder age(int age){
            this.age = age;
            return this;

        }public PersonBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Person getResult(){
            return new Person(gender, age, surname);
        }
    }

    public Person getRandom(){
        RandomEnumGenerator<Gender> gen = new RandomEnumGenerator<>(Gender.class);
        Gender gender = gen.randomEnum();
        Random r = new Random();
        String surname;
        if (gender.title.equals("male")){
            RandomEnumGenerator<MSurname> sur = new RandomEnumGenerator<>(MSurname.class);
            MSurname msurname = sur.randomEnum();
            surname = msurname.title;
        } else {
            RandomEnumGenerator<FSurname> sur = new RandomEnumGenerator<>(FSurname.class);
            FSurname fsurname = sur.randomEnum();
            surname = fsurname.title;
        }
        return Person.builder()
                .gender(gender.title)
                .age(r.nextInt(90))
                .surname(surname)
                .getResult();
    }
    @Override
    public String toString() {
        return "Person:gender:" + getGender() + ":age:" + getAge() + ":surname:" + getSurname();
    }

    @Override
    public int compareTo(Sortable object) {
        if (object instanceof Person) {
            int t;
            // Сравнение по фамилии
            t = this.surname.toLowerCase().compareTo(((Person) object).surname.toLowerCase());
            if (t != 0) {
                return t;
            }
            // сравнение по возрасту
            t = Integer.compare(((Person) object).age, this.age); // Старший идет первым
            if (t != 0) {
                return t;
            }// сравнение по полу
            t = this.gender.toLowerCase().compareTo(((Person) object).gender.toLowerCase());
            return t;
        } else if (object instanceof Animal) {
            return 1; // Person идет после Animal
        } else if (object instanceof Barrel) {
            return 1; // Person идет после Barrel
        }
        return 0; // Неизвестный тип
    }
}