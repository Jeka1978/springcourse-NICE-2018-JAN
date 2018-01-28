package aop_lab;

import aop_lab.services.MainService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

/**
 * @author Evgeny Borisov
 */


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:mails.properties")
public class MainConfig {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
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
