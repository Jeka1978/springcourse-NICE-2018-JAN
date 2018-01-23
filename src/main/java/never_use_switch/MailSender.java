package never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */

public class MailSender {

    private Map<Integer, MailGenerator> map = new HashMap<>();



    private MailDao mailDao = new MailDaoImpl();

    public void sendMail() {
        int mailCode = mailDao.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
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
