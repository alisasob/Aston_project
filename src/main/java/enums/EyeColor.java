package main.java.enums;

public enum EyeColor {
    BLUE ("Blue"),
    GREEN ("Green"),
    GREY ("Grey"),
    BROWN ("Brown"),
    RED ("Red");

    public final String title;

    EyeColor(String s){
        this.title = s;
    }
}
