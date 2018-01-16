package my_spring;

import lombok.Data;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Data
public class Hobbit {
    @InjectRandomInt(min = 3, max = 7)
    private int power;
    @InjectRandomInt(min = 3, max = 7)
    private int speed;


}
