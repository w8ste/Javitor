import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

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
                try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
                    fw.write(textArea.getText());
                    fw.close();

            }   catch (Exception ex) {
                    System.out.println("Error");
                }

            }
        });
    }

}
