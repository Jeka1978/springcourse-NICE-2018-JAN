package never_use_switch;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */

@Service
public class MailSender {

    @Autowired
    private Map<String, MailGenerator> map;

    @Autowired
    private MailDao mailDao;

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        int mailCode = mailDao.getMailCode();
        MailGenerator mailGenerator = map.get(Integer.toString(mailCode));
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }
        String html = mailGenerator.generateHtml();
        send(html);
    }

    private void send(String html) {
        System.out.println("sending... "+html);
    }
}
