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
        intializeColors();
    }


    private void intializeColors() {
        //general regex
        //String general = jjjjjjjjjj"\\b(class|public|private|protected|int|void|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b";  

        // red/leftover regex
        String general = "\\b(class|int|void|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b"; 
        regexSet.add(general);
        colorMap.put(general, Color.RED);
        
        // green/scope regex
        String g = "\\b(public|private|protected)";
        regexSet.add(g);
        colorMap.put(g, Color.GREEN);
    }
    
    public void highlight(int lang) {
    SimpleAttributeSet keyword = new SimpleAttributeSet(); 
        StyleConstants.setForeground(keyword, Color.BLACK);
        if(lang == 0) noHighlight();
        else {
            javaHighlight("\\b(class|int|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b", Color.RED, true);
            javaHighlight("\\b(public|private|protected)\\b", Color.GREEN, false);
            javaHighlight("\\b(void)\\b", Color.BLUE, false); //void oben wieder einfügen
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
    private void matchRed() {
    SimpleAttributeSet keyword = new SimpleAttributeSet(); 
    
        // this regex descripes all the left over keywords for now
        String regex = "\\b(class|public|private|protected|int|void|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b";
        Pattern pattern = Pattern.compile(regex);
        
        try {
            StyledDocument document = textArea.getStyledDocument();
            String text = document.getText(0, document.getLength());
            Matcher matcher = pattern.matcher(text);

            document.setCharacterAttributes(0, document.getLength(), keyword, true);
            StyleConstants.setForeground(keyword, Color.RED);

            while(matcher.find()) {
                document.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()), keyword, true);
            }
        }
        catch (Exception e) { System.out.println(e); }
    }

    private void matchScope() {
        SimpleAttributeSet keyword = new SimpleAttributeSet(); 
    
        //scope regex
        String regexScope = "\\b(public|private|protected)\\b";
        Pattern scopePattern = Pattern.compile(regexScope);

        try {
            StyledDocument document = textArea.getStyledDocument();
            String text = document.getText(0, document.getLength());
            Matcher matcher = scopePattern.matcher(text);

            document.setCharacterAttributes(0, document.getLength(), keyword, false);
            StyleConstants.setForeground(keyword, Color.BLUE);

            while(matcher.find()) {
                document.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()), keyword, false);
            }
        }
        catch (Exception e) { System.out.println(e); }
    }

}
