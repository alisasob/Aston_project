import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        AnimalBuilder ab = new AnimalBuilder();
        ab.setValues("cat", "green", true);
        Animal a = ab.getResult();
        BarrelBuilder bb = new BarrelBuilder();
        bb.setValues(10, "oil", "metal");
        Barrel b = bb.getResult();
        PersonBuilder pb = new PersonBuilder();
        pb.setValues("male", 22, "Ivanov");
        Person p = pb.getResult();
        Stream.of(a, b, p).forEach(x->System.out.println(x.toString()));
        //System.out.println(p.toString());
    }
}