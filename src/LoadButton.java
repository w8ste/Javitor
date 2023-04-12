import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;


public class LoadButton extends JButton {

    private JFrame parentFrame;
    public LoadButton(JFrame parentFrame) {
        this.setText("Load");
        this.setSize(new Dimension(100, 35));
        this.parentFrame = parentFrame;
        clickAction();
    }

    private void clickAction() {
        this.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int response = chooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                //This is where a real application would open the file.
                try(FileReader fileReader = new FileReader(file)) {
                    int data = fileReader.read();
                    LinkedList<Character> list = new LinkedList<>();
                    while(data != -1) {
                        list.add((char)data);
                        data = fileReader.read();
                    }
                    fileReader.close();
                    StringBuilder s = new StringBuilder();
                    for(Character c : list)  {
                        s.append(c);
                    }
                    new MyFrame(s.toString());
                    //write text to file
                    parentFrame.dispose();

                } catch(Exception ex) {
                    System.out.println("Error");
                }



            }


        });
    }

}
