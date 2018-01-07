package com.application.update.window;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

    public static JTextArea label = new JTextArea("Input:");

    public GUI() {
        super("Logs");
        this.setBounds(100,100,250,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.add(label);

    }
}
