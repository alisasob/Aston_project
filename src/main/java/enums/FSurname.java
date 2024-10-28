package main.java.enums;

public enum FSurname {
    IVANOVA ("Ivanova"),
    SMIRNOVA ("Smirnova"),
    SOKOLOVA ("Sokolova"),
    KARENINA ("Karenina"),
    KOROLEVA ("Koroleva"),
    BORISOVA ("Borisova"),
    ODINCOVA ("Odincova"),
    LEBEDEVA ("Lebedeva"),
    PETROVA ("Petrova"),
    ROSTOVA ("Rostova");
    public final String title;

    FSurname(String s) {
        this.title = s;
    }
}
