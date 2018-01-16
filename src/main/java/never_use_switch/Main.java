package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class Main {



    public static void main(String[] args) throws InterruptedException {
        MailSender mailSender = new MailSender();
        while (true) {
            try {
                mailSender.sendMail();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
