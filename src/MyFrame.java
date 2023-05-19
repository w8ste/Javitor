import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyFrame extends JFrame {
    private JTextArea textArea;
    private JMenuBar jMenuBar;
    private JMenu file;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        createMenuBar();
        makeButton();
        makeTextArea();
        this.setVisible(true);


    }

    /*
     only used when creating a frame with content inside
     e.g. when loading a file
     */
    public MyFrame(String s) {
        makeTextArea(s);
        makeButton();
        createMenuBar();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void makeButton() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setPreferredSize(new Dimension(100, 35));
        buttonPanel.setMaximumSize(new Dimension(100, 600));

        SaveButton saveButton = new SaveButton(textArea);

        LoadButton loadButton = new LoadButton(this);

        JButton newFileButton = new JButton();
        newFileButton.setText("New File");
        newFileButton.setSize(100, 35);
        newFileButton.addActionListener(e -> new MyFrame());

        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setSize(100, 35);
        clearButton.addActionListener(e -> textArea.setText(""));

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(newFileButton);
        buttonPanel.add(clearButton);

        this.add(buttonPanel, BorderLayout.NORTH);

        //while(true) if(textArea.getText().toCharArray()[0] == 'a') textArea.setText("Hello World");
    }

    public void makeTextArea() {
        textArea = new JTextArea();
        initializeArea();
    }

    public void makeTextArea(String s) {
        textArea = new JTextArea(s);
        initializeArea();
    }

    private void initializeArea() {
        textArea.setVisible(true);
        textArea.setLayout(null);
        JPanel areaPanel = new JPanel();

        //create scrollpane
        JScrollPane scrollPane = new JScrollPane(textArea);

        areaPanel.setLayout(new GridLayout(1, 1));
        areaPanel.setPreferredSize(new Dimension(550, 400));
        areaPanel.setMaximumSize(new Dimension(1000, 5000));
        areaPanel.add(scrollPane, BorderLayout.CENTER);


        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.add(areaPanel);

    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.add(new fileMenuBar(this, "File"));
        menuBar.setVisible(true);
        this.setJMenuBar(menuBar);
    }



}
