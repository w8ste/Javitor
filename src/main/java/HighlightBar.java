
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighlightBar extends JMenu implements ActionListener {
   
    private final JMenuItem noHighlight;
    private final JMenuItem javaHighlight;
    private final MyFrame frame; 
    public HighlightBar(MyFrame frame, String name) {
        super(name);

        //create the no highlight option
        this.noHighlight = new JMenuItem("No highlighting");
        noHighlight.addActionListener(this);

        //create java highltighting option
        this.javaHighlight = new JMenuItem("Java highlighting");
        javaHighlight.addActionListener(this);

        this.frame = frame;

        //add to JMenu
        this.add(noHighlight);
        this.add(javaHighlight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(noHighlight)) {
            //set to no highlight with 0
            frame.setLang(0);
            frame.getHighlighter().highlight(frame.getLang());
        }
        else if(e.getSource().equals(javaHighlight)) {
            //set to java with 1
            frame.setLang(1);
            frame.getHighlighter().highlight(frame.getLang());
        }
    }
} 
