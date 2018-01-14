package ploymorphism;

/**
 * @author Evgeny Borisov
 */
public class Dog implements Animal {
    @Override
    public void makeVoice() {
        System.out.println("aua au");
    }

    public void bringStick() {
        System.out.println("Stick is yours, take it");

    }
}
