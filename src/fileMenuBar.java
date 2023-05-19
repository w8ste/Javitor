import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class fileMenuBar extends JMenu implements ActionListener {

    private final JMenuItem exit;
    private final JMenuItem newFile;
    private final JMenuItem save;
    private final JMenuItem load;
    private final JMenuItem clear;
    private final JTextArea textArea;
    JFrame frame;
    public fileMenuBar(JFrame frame, JTextArea textArea, String name) {
        super(name);

        //create save item
        this.save = new JMenuItem("Save");
        save.addActionListener(this);

        // create new file item
        this.newFile = new JMenuItem("New File");
        newFile.addActionListener(this);

        // create load file item (functionality still need implementation)
        this.load = new JMenuItem("Load file");
        load.addActionListener(this);

        // create clear item
        this.clear = new JMenuItem("Clear");
        clear.addActionListener(this);

        // create exit item
        this.exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        // add to Jmenu
        this.add(save);
        this.add(newFile);
        this.add(load);
        this.add(clear);
        this.add(exit);
        this.frame = frame;

        this.textArea = textArea;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exit)) {
            frame.dispose();
            System.out.println("Hello");
        }
        else if(e.getSource() == newFile) {
            frame.dispose();
            new MyFrame();
        }
        else if(e.getSource() == clear) {
            textArea.setText("");
        }
        else if(e.getSource() == save) {

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
        }
        else if(e.getSource() == load) {
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
                    frame.dispose();

                } catch(Exception ex) {
                    System.out.println("Error");
                }
            }
        }
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
