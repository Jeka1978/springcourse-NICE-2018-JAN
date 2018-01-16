package never_use_switch;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class MailDaoImpl implements MailDao {
    @Override
    public int getMailCode() {
        Random random = new Random();
        return random.nextInt(3) + 1;//1 or 2
    }
}
