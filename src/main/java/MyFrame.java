import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class MyFrame extends JFrame {
    
    /*
     * 0: no syntax highlighting
     * 1: Java
     */
    private int lang = 0;
    private JTextPane textArea;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    Highlighter highlighter;    

    public MyFrame() {
        this("");
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
        clearButton.setText("Highlight");
        clearButton.setSize(100, 35);
        clearButton.addActionListener(e -> highlighter.highlight(1));

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(newFileButton);
        buttonPanel.add(clearButton);

        this.add(buttonPanel, BorderLayout.NORTH);
    }

    public void makeTextArea() {
        makeTextArea("");
    }

    public void makeTextArea(String s) {
        textArea = new JTextPane();
        textArea.setText(s);
        textArea.setBounds(50, 50, 500, 500);
        textArea.addKeyListener(new KeyChecker(this)); 
        textArea.setVisible(true);
        textArea.setLayout(null);
        JPanel areaPanel = new JPanel();

        //create scrollpane
        JScrollPane scrollPane = new JScrollPane(textArea);

        areaPanel.setLayout(new GridLayout(1, 1));
        areaPanel.setPreferredSize(new Dimension(550, 400));
        areaPanel.setMaximumSize(new Dimension(1000, 5000));
        areaPanel.add(scrollPane, BorderLayout.CENTER);

        this.add(areaPanel);
        this.highlighter = new Highlighter(textArea);    
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.add(new fileMenuBar(this, textArea,"File"));
        
        menuBar.add(new HighlightBar(this, "Highlights"));
        
        menuBar.setVisible(true);
        this.setJMenuBar(menuBar);
    }

    public void setLang(int value) {
        if(value >= 0 && value < 3) {
            lang = value;
        }
    }

    public int getLang() {
        return this.lang;
    }

    public Highlighter getHighlighter() {
        return this.highlighter;
    } 

}

/*
 * handling index highlighting with this 
 * has some problems, which is why i 
 * currenty don't use it anymore
 */
class KeyChecker extends KeyAdapter {
    MyFrame myFrame;
    public KeyChecker(MyFrame myFrame) {
         this.myFrame = myFrame;
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        Timer timer = new Timer();
        TimerTk timerTk = new TimerTk(myFrame);
        timer.scheduleAtFixedRate(timerTk, 0, 1);
    }
}

