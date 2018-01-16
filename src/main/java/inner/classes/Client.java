package inner.classes;

import lombok.*;
import lombok.experimental.Wither;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@Wither
public class Client {
    private final String name;
    private final int age;
    private final int bonus;
    private final int salary;


    public static class Builder {
        private String name;
        private int age;
        private int bonus;
        private int salary;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder bonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public Builder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Client build() {
            validate();
            Client client = new Client(name, age, bonus, salary);
            clean();
            return client;
        }

        private void clean() {
            name=null;
            age=0;
        }

        private void validate() {
            if (name == null) {
                throw new IllegalStateException("name can't be null");
            }
        }
    }

}





