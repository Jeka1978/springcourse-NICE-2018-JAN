package never_use_switch;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@Getter
public enum MailTypeEnum {
    WELCOME(1, new WelcomeMailGenerator()),
    EMAIL_CALLBACK(2, new EmailCallbackMailGenerator());

    private final int dbCode;
    private final MailGenerator mailGenerator;


    public static MailTypeEnum findByDbCode(int dbCode) {
        return Arrays.stream(values())
                .filter(mailTypeEnum -> mailTypeEnum.dbCode == dbCode)
                .findAny()
                .get();
    }




}
