import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JTextPane;

import java.awt.Color;
    
public class Highlighter{
    HashMap<String, Color> colorMap;
    HashSet<String> regexSet;
    JTextPane textArea;
    public Highlighter(JTextPane textArea) {
        this.textArea = textArea;
        intializeColors();
    }


    private void intializeColors() {
        //general regex
        String general = "\\b(class|public|private|protected|int|void|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b";  
        regexSet.add(general);
        colorMap.put(general, Color.BLACK);

        // red/leftover regex
        general = "\\b(class|public|private|protected|int|void|static|final|float|if|else|for|while|try|catch|boolean|import|return)\\b"; 
        regexSet.add(general);
        colorMap.put(general, Color.RED);
        
        // green/scope regex
        general = "\\b(public|private|protected)";
        regexSet.add(general);
        colorMap.put(general, Color.RED);
    

    }

}
