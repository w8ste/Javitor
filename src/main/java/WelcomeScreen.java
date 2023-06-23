import java.awt.*;



import java.awt.event.*;

import javax.swing.*;



public class WelcomeScreen extends JFrame{

    private JLabel titleLabel;
    private JPanel buttonPanel;
    private JPanel panel;

    WelcomeScreen(){

        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createPanel();

        this.add(panel);
        this.setVisible(true);
    }

    private void createPanel() {

        createButtonPanel();

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, (int)(this.getPreferredSize().getHeight() * 0.7 - titleLabel.getHeight() / 2)));

        //add a component listener, so the panel always aligns as wished
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                JPanel c = (JPanel) evt.getSource();
                c.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 0, (int)(c.getHeight() * 0.3 - titleLabel.getHeight() / 2)));
            }
        });

        panel.add(buttonPanel);

    }

    private void createButtonPanel() {

        titleLabel = new JLabel("JAVITOR");
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD, 30));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.setPreferredSize(new Dimension(125, 250));

        LoadButton loadButton = new LoadButton(this);

        JButton newFileButton = new JButton();
        newFileButton.setText("New File");
        newFileButton.setSize(100, 35);
        newFileButton.addActionListener(e -> {
            new MyFrame();
            this.dispose();

        });

        //add all the components to the label
        buttonPanel.add(titleLabel);
        buttonPanel.add(Box.createRigidArea(new Dimension(100, 100)));
        buttonPanel.add(loadButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(100, 100)));
        buttonPanel.add(newFileButton);
    }
}
