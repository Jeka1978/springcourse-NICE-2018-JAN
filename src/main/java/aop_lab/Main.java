package aop_lab;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop_lab");
        MainService mainService = context.getBean(MainService.class);
        while (true) {
            try {
                mainService.doWork();
            } catch (Exception e) {
                System.out.println("this is a problem...");
            }
            Thread.sleep(500);
        }
    }
}
