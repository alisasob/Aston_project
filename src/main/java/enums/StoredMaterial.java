package main.java.enums;

public enum StoredMaterial {
    SAND ("Sand"),
    WATER ("Water"),
    OIL ("Oil"),
    WINE ("Wine");
    public final String title;

    StoredMaterial(String s) {
        this.title = s;
    }
}
