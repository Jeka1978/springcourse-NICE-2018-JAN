package screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Component
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;

    @Autowired
    private Random random;

    @PostConstruct
    public void init() {
        setSize(100,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void moveToRandomLocation() {
        setLocation(random.nextInt(800),random.nextInt(600));
        getContentPane().setBackground(color);
        repaint();
    }

}




