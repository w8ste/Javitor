import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
public class MyFrame extends JFrame {

    private JButton jButton;
    private JTextArea textArea;
    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        makeButton();
        makeTextArea();

    }

    public void makeButton() {
        jButton = new JButton();
        jButton.setBounds(200, 3, 75, 35);
        jButton.addActionListener(e -> {
            //this is a placeholder
            if(e.getSource() == jButton) System.out.println(textArea.getText());
        });

        this.add(jButton);
    }

    public void makeTextArea() {
        textArea = new JTextArea();
        textArea.setVisible(true);
        textArea.setLayout(null);
        textArea.setBounds(0, 41, 500, 500);
        this.add(textArea);

    }



}
