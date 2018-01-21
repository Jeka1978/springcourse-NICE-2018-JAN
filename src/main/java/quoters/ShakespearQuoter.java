package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public class ShakespearQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
