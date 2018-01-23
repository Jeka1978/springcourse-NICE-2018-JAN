package quoters;

import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author Evgeny Borisov
 */
@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;


    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void killAll() {
        new Thread(() -> System.out.println("You are terminated...")).start();

    }













}
