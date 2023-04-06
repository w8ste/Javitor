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






    }

    public void makeButton() {
        JButton b = new JButton();
        b.setBounds(200, 0, 75, 35);
        this.add(b);
    }

    public void makeTextArea() {
        JTextArea area = new JTextArea();
        area.setVisible(true);
        area.setLayout(null);
        area.setBounds(0, 40, 500, 500);
        this.add(area);

    }



}
