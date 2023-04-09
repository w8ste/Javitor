import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class SaveButton extends JButton {

    private final JTextArea textArea;

    public SaveButton(JTextArea textArea) {
        this.setText("Save");
        this.setSize(new Dimension(100, 35));
        this.textArea = textArea;
        clickAction();
    }

    private void clickAction() {
        this.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int response = chooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                String s = chooser.getSelectedFile().toString();
                if(isDefaultFormat(s)) {
                    try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
                        fw.write(textArea.getText());
                        fw.close();
                    }catch (Exception ex) {
                        System.out.println("Error");
                    }
                }
                else {
                    try(FileWriter fw = new FileWriter(chooser.getSelectedFile())) {
                        fw.write(textArea.getText());
                        fw.close();
                    }catch (Exception ex) {
                        System.out.println("Error");
                    }
                }

            }
        });
    }

    private boolean isDefaultFormat(String s) {
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(c == '.') {
                return false;
            }
        }
        return true;
    }



}
