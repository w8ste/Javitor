import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.xml.stream.Location;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
public class MyFrame extends JFrame {

    private JButton jButton;
    private JTextArea textArea;
    private JPanel panel;
    public MyFrame() {
        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setVisible(true);

        makeButton();
        makeTextArea();*/

        /*
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setPreferredSize(new Dimension(100, 35));
        buttonPanel.setMaximumSize(new Dimension(100, 600));

        JButton saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setSize(100, 35);
        JButton newFileButton = new JButton();
        newFileButton.setText("New File");
        newFileButton.setSize(100, 35);
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setSize(100, 35);

        buttonPanel.add(saveButton);
        buttonPanel.add(newFileButton);
        buttonPanel.add(clearButton);

        Location[][] array = null;
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(600, 600));
        centerPanel.setMinimumSize(new Dimension(600, 600));

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(100, 600));
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(800, 100));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 100));

        this.add(buttonPanel, BorderLayout.NORTH);*/


        makeTextArea();
        makeButton();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    public void makeButton() {
        /*jButton = new JButton();
        jButton.setBounds(200, 3, 75, 35);
        jButton.addActionListener(e -> {
            //this is a placeholder
            if(e.getSource() == jButton) System.out.println(textArea.getText());
        });

        this.add(jButton, BorderLayout.NORTH);*/

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setPreferredSize(new Dimension(100, 35));
        buttonPanel.setMaximumSize(new Dimension(100, 600));

        JButton saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setSize(100, 35);
        JButton newFileButton = new JButton();
        newFileButton.setText("New File");
        newFileButton.setSize(100, 35);
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setSize(100, 35);

        buttonPanel.add(saveButton);
        buttonPanel.add(newFileButton);
        buttonPanel.add(clearButton);

        this.add(buttonPanel, BorderLayout.NORTH);
    }

    public void makeTextArea() {
        textArea = new JTextArea();
        textArea.setVisible(true);
        textArea.setLayout(null);
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(1, 1));
        areaPanel.setPreferredSize(new Dimension(550, 400));
        areaPanel.setMaximumSize(new Dimension(1000, 5000));
        areaPanel.add(textArea, BorderLayout.CENTER);
        this.add(areaPanel);
    }



}
