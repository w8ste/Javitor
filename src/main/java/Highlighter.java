import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyleConstants;
import java.awt.Color;
    
public class Highlighter{
    HashMap<String, Color> colorMap = new HashMap<>();
    HashSet<String> regexSet = new HashSet<>();
    JTextPane textArea;
    public Highlighter(JTextPane textArea) {
        this.textArea = textArea;
    }
     
    public void highlight(int lang) {
        if(lang == 0) noHighlight();
        else {
            javaHighlight("\\b(class|int|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b", Color.RED, true);
            javaHighlight("\\b(public|private|protected)\\b", Color.PINK, false);
            javaHighlight("\\b(void)\\b", Color.BLUE, false); 
        }
    }

    private void javaHighlight(String regex, Color color, boolean i) {
            SimpleAttributeSet keyword = new SimpleAttributeSet(); 
            Pattern pattern = Pattern.compile(regex);

            try {
                StyledDocument document = textArea.getStyledDocument();
                String text = document.getText(0, document.getLength());
                Matcher matcher = pattern.matcher(text);

                document.setCharacterAttributes(0, document.getLength(), keyword, i);
                StyleConstants.setForeground(keyword, color);

                while(matcher.find()) {
                    document.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()), keyword, i);
                }
            }
            catch (Exception e) { System.out.println(e); }

    }

    private void noHighlight() {
        String regex = "\\b(class|public|private|protected|int|void|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b";  
        Pattern pattern = Pattern.compile(regex);
        SimpleAttributeSet keyword = new SimpleAttributeSet(); 

        try {
            StyledDocument document = textArea.getStyledDocument();
            String text = document.getText(0, document.getLength());
            Matcher matcher = pattern.matcher(text);

            document.setCharacterAttributes(0, document.getLength(), keyword, true);
            StyleConstants.setForeground(keyword, Color.BLACK);

            while(matcher.find()) {
                document.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()), keyword, true);
            }
        }
        catch (Exception e) { System.out.println(e); }
    }
}
