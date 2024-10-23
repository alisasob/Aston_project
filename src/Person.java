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

    @Override
    public String toString() {
        return "[" + getSurname() + ", " + getGender() + ", " + getAge() + "]";
    }
}
