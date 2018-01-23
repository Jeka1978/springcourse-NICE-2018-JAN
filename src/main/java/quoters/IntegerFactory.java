package quoters;

import lombok.RequiredArgsConstructor;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
public class IntegerFactory {
    private final int max;

    public int createInt() {
        return new Random().nextInt(max);
    }
}
