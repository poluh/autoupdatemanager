package com.application.update;

import com.application.update.window.GUI;

import java.io.IOException;

import static com.application.update.file.work.WorkFile.installNewApp;
import static com.application.update.file.work.WorkFile.workFile;
import static com.application.update.server.ftp.connect.ConfigConnect.connection;
import static com.application.update.window.GUI.label;
import static java.lang.Thread.sleep;

public class Start {
    public static void main(String[] args) throws IOException {
        GUI app = new GUI();
        app.setVisible(true);
        workFile();
        connection();
        installNewApp();
        label.setText(label.getText() + "Success!\n");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.dispose();
    }
}
