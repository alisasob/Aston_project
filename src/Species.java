import java.util.Random;

public enum Species {
    CAT ("Cat"),
    DOG ("Dog"),
    RAT ("Rat"),
    LION ("Lion"),
    BEAR ("Bear"),
    HORSE ("Horse"),
    DINOSAUR ("Dinosaur"),
    RABBIT ("Rabbit"),
    OCTOPUS ("Octopus");
    final String title;

    Species(String s) {
        this.title = s;
    }
}
