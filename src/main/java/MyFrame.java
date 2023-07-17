import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    
    String regex = "\\b(class|int|void|static|final|public|private|protected|float|if|else|for|while|try|catch|boolean|import|return)\\b";
    Pattern pattern = Pattern.compile(regex);

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
        clearButton.setText("Highlight");
        clearButton.setSize(100, 35);
        clearButton.addActionListener(e -> highlight());

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(newFileButton);
        buttonPanel.add(clearButton);

        this.add(buttonPanel, BorderLayout.NORTH);

    }


    void highlight()
    {
        SimpleAttributeSet keyword = new SimpleAttributeSet();
        StyleConstants.setForeground(keyword, Color.BLACK);
        if(lang == 0) {
            try{
                StyledDocument document= textArea.getStyledDocument();
                String text = document.getText(0, document.getLength());
                Matcher matcher = pattern.matcher(text);
                document.setCharacterAttributes(0, document.getLength(), keyword, true);

                while (matcher.find()) {
                    document.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()), keyword, true);
                }
            }catch(Exception e) { System.out.println(e); }
        }
        if(lang == 1) {
            try
            {
                StyledDocument document = textArea.getStyledDocument();
                String text = document.getText(0, document.getLength());
                Matcher matcher = pattern.matcher(text);

                document.setCharacterAttributes(0, document.getLength(), keyword, true);
                StyleConstants.setForeground(keyword, Color.RED);
                //create multiple matcher for different kinds of code ?

                while(matcher.find()) {
                    document.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()), keyword, true);
                }

                /* After every match change color accordingly
                   StyleConstants.setForeground(keyword, Color.BLUE); */
                //StyleConstants.setForeground(keyword, Color.BLACK);
                //document.setCharacterAttributes(document.getLength(), 1, keyword, true);
            }
            catch (Exception e) { System.out.println(e); }
        }
    }

    public void makeTextArea() {
        textArea = new JTextPane();
        initializeArea();
    }

    public void makeTextArea(String s) {
        textArea = new JTextPane();
        textArea.setText(s);
        initializeArea();
    }

    private void initializeArea() {
        textArea.setBounds(50, 50, 500, 500);
        textArea.addKeyListener(new KeyChecker(this));
        this.addKeyListener(new KeyChecker(this));
        
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

}

class KeyChecker extends KeyAdapter {
    MyFrame myFrame;
    public KeyChecker(MyFrame myFrame) {
         this.myFrame = myFrame;
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        myFrame.highlight();
    }
}

