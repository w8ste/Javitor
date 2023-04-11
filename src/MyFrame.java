import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;

public class MyFrame extends JFrame {
    private JTextArea textArea;
    public MyFrame() {
        makeTextArea();
        makeButton();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void makeButton() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setPreferredSize(new Dimension(100, 35));
        buttonPanel.setMaximumSize(new Dimension(100, 600));

        SaveButton saveButton = new SaveButton(textArea);

        JButton newFileButton = new JButton();
        newFileButton.setText("New File");
        newFileButton.setSize(100, 35);
        newFileButton.addActionListener(e -> new MyFrame());

        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setSize(100, 35);
        clearButton.addActionListener(e -> textArea.setText(""));

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
