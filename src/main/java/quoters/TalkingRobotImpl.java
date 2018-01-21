package quoters;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;
    @Override
    public void talk() {
       quoters.forEach(Quoter::sayQuote);
    }
}
