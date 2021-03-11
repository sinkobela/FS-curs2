package ro.fasttrackit.curs2.interfaces;

public interface Pet {
    String NAME = "PET";

    String getName();
    String makeSound();

    default String getColor() {
        return "BROWN";
    }


    default String phrase() {
        logPhraseCall();
        return getName() + ":" + makeSound();
    }

    private void logPhraseCall() {
        System.out.println("Phrase method was called");
    }
}
