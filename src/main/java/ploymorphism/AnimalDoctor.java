package ploymorphism;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class AnimalDoctor {

    private List<Integer> numbers = new ArrayList<>();
    public void treat(Animal animal) {

        numbers.add(1000);


        if (animal instanceof Dog) {
            ((Dog) animal).bringStick();
        }
    }



















}
