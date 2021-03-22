package model;

import javax.swing.*;
import java.awt.*;

public class ChatGUI {
    private JFrame mainFrame;
    private JLabel headerLabel;


    public ChatGUI() {
        prepareGUI();
    }

    public void prepareGUI() {
        mainFrame = new JFrame("Caixa de Dialogos");
        mainFrame.setSize(400, 400);
         mainFrame.setLayout(new GridLayout(10, 1));
        headerLabel = new JLabel("Conversas:", JLabel.CENTER);
        
       
        mainFrame.add(headerLabel);
    
    }

    public void chatbox(String msg) {
        JLabel statusLabel = new JLabel();
        
        statusLabel.setText(msg+'\n');
       
        statusLabel.setHorizontalTextPosition(SwingConstants.CENTER);
     
       
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);

    }
}
