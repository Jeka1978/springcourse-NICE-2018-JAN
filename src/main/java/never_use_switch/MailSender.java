package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class MailSender {
    private MailDao mailDao = new MailDaoImpl();

    public void sendMail() {
        int mailCode = mailDao.getMailCode();
        String html = MailTypeEnum.findByDbCode(mailCode).getMailGenerator().generateHtml();
        send(html);
    }

    private void send(String html) {
        System.out.println("sending... "+html);
    }
}
