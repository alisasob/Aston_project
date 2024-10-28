package main.java.enums;

public enum MSurname {
    IVANOV ("Ivanov"),
    SMIRNOV ("Smirnov"),
    SOKOLOV ("Sokolov"),
    DUBROVSKY ("Dubrovsky"),
    SIDOROV ("Sidorov"),
    BORISOV ("Borisov"),
    INOCHKIN ("Inochkin"),
    LEBEDEV ("Lebedev"),
    PETROV ("Petrov"),
    SAVIN ("Savin");
    public final String title;

    MSurname(String s) {
        this.title = s;
    }
}
