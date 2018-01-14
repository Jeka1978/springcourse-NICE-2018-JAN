package lombok_examples;

import lombok.*;
import lombok.experimental.Wither;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Getter
@ToString(exclude = "age")
@Wither
@AllArgsConstructor
@Builder
@Slf4j
public class Person {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private Integer salary;

    @Singular
    private List<String> beers;

    @Singular("child")
    private Map<String,Integer> childrenWithAge;

    public void printMySelf() {
        log.info(this.toString());
    }

}
