package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Evgeny Borisov
 */
public class ShakespearQuoter implements Quoter {
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
