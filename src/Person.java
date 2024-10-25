import java.util.Random;

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
}
