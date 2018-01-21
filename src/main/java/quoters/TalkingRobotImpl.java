package quoters;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Setter
@RequiredArgsConstructor
public class TalkingRobotImpl implements TalkingRobot {
    private final List<Quoter> quoters;


    @Override
    @PostConstruct
    public void talk() {
       quoters.forEach(Quoter::sayQuote);
    }


}
