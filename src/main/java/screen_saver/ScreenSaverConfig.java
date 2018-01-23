package screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class ScreenSaverConfig {
    @Autowired
    private ApplicationContext context;

    @Bean
    public Random random() {
        System.out.println("random was created");
        return new Random();
    }



    @Bean
    @Scope(value = "twoSeconds",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        return new Color(random().nextInt(255), random().nextInt(255), random().nextInt(255));
    }


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);

        while (true) {
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(200);
        }
    }
}
