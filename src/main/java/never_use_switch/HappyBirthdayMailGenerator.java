package never_use_switch;

/**
 * @author Evgeny Borisov
 */
@MailCode(3)
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "<html> Happy Birthday</html>";
    }
}
