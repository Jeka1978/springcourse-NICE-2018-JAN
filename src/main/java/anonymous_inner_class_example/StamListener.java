package anonymous_inner_class_example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeny Borisov
 */
public class StamListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button was clicked...");
    }
}
