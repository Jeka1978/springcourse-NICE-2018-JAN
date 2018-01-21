package my_spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

/**
 * @author Evgeny Borisov
 */
public class ConsoleSpeaker implements Speaker {


    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
