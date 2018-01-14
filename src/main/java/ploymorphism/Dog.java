package ploymorphism;

import lombok.EqualsAndHashCode;

/**
 * @author Evgeny Borisov
 */
public class Dog implements Animal {
    private int speed;
    private String name;

    @Override
    public void makeVoice() {
        System.out.println("aua au");
    }

    public void bringStick() {
        System.out.println("Stick is yours, take it");

    }
}
