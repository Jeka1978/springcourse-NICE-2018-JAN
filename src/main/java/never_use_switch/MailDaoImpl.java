package never_use_switch;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Repository
public class MailDaoImpl implements MailDao {
    @Override
    public int getMailCode() {
        Random random = new Random();
        return random.nextInt(3) + 1;//1 or 2
    }
}
