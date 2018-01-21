package quoters;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Setter
@RequiredArgsConstructor
public class TalkingRobotImpl implements TalkingRobot {
    private final List<Quoter> quoters;


    @Override
    public void talk() {
       quoters.forEach(Quoter::sayQuote);
    }
}
