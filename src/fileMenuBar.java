import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class fileMenuBar extends JMenu implements ActionListener {

    private JMenuItem exit;
    private JMenuItem newFile;
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem clear;
    private JTextArea textArea;
    JFrame frame;
    public fileMenuBar(JFrame frame, String name) {
        super(name);
        this.exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        this.newFile = new JMenuItem("New File");
        newFile.addActionListener(this);
        this.save = new JMenuItem("Save");
        save.addActionListener(this);
        this.load = new JMenuItem("Load file");
        load.addActionListener(this);
        this.add(exit);
        this.add(newFile);
        this.add(save);
        this.add(load);
        this.frame = frame;
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
