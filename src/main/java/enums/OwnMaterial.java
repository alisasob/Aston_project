package main.java.enums;

public enum OwnMaterial {
    WOOD ("Wood"),
    METAL ("Metal"),
    PVC ("PVC"),
    CLAY ("Clay");
    public final String title;

    OwnMaterial(String s) {
        this.title = s;
    }
}
