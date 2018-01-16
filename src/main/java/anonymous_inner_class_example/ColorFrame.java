package anonymous_inner_class_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeny Borisov
 */
public class ColorFrame extends JFrame {

    public ColorFrame() {
        int[] x = new int[1];
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("click to change color");

        button.addActionListener(e -> {
            System.out.println(x[0]++);
           getContentPane().setBackground(Color.RED);
        });


        add(button, BorderLayout.NORTH);
        setVisible(true);
    }
}
