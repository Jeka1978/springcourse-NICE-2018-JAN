package enums;

import lombok.*;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private MaritalStatus maritalStatus;
}
