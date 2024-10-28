package main.java.entity;

import java.util.Random;
import main.java.enums.FSurname;
import main.java.enums.Gender;
import main.java.enums.MSurname;
import main.java.rng.RandomEnumGenerator;

public class Person {
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
        RandomEnumGenerator gen = new RandomEnumGenerator(Gender.class);
        Gender gender = (Gender) gen.randomEnum();
        Random r = new Random();
        String surname;
        if (gender.title.equals("male")){
            RandomEnumGenerator sur = new RandomEnumGenerator(MSurname.class);
            MSurname msurname = (MSurname) sur.randomEnum();
            surname = msurname.title;
        } else {
            RandomEnumGenerator sur = new RandomEnumGenerator(FSurname.class);
            FSurname fsurname = (FSurname) sur.randomEnum();
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
}