public class PersonBuilder implements Builder<String, Integer, String>{
    private String gender;
    private int age;
    private String surname;

    @Override
    public void setValues (String val1, Integer val2, String val3){
        this.gender = val1;
        this.age = val2;
        this.surname = val3;
    }

    public Person getResult(){
        return new Person(gender, age, surname);
    }
}
