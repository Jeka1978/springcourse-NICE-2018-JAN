package inner.classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Client.Builder builder = new Client.Builder();
        Client client = builder.age(12).name("Moshe").build();
        client = client.withName("Jeka");
        client = client.withAge(50).withSalary(20000).withBonus(100);
        System.out.println(client);





    }
}
