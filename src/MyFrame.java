import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;

import java.util.EventListener;
public class MyFrame extends JFrame {
    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        JButton b = new JButton();
        b.setBounds(200, 0, 100, 50);
        JTextArea area = new JTextArea();
        area.setVisible(true);
        area.setLayout(null);
        area.setBounds(0, 110, 500, 500);
        this.add(area);
        this.add(b);




    }

}
