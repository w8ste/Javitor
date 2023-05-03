import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fileMenuBarListener implements ActionListener {

    private JMenuItem exit;
    private JFrame frame;

    public fileMenuBarListener(JFrame frame, JMenuItem exit) {
        this.exit = exit;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit) {
            System.exit(0);
        }
    }
}
