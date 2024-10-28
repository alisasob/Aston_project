package main.java.enums;

public enum Gender {
    MALE ("male"),
    FEMALE ("female");
    public final String title;

    Gender(String s) {
        this.title = s;
    }
}
