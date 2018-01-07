package com.application.update.server.ftp.connect;

import com.application.update.file.work.WorkFile;
import com.application.update.window.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.application.update.window.GUI.label;
import static java.lang.Thread.sleep;

public class ConfigConnect {

    private final static String LOGIN = "";
    private final static String PASSWORD = "";
    private final static String HOST = "files..com";
    private final static int PORT = 21;
    private final static String DIR = "/tmp/updates";
    private final static String PATH_TO_CONFIG = "config.txt";

    private static int getVersion() {
        try {
            BufferedReader config = new BufferedReader(new FileReader(new File(PATH_TO_CONFIG)));
            return Integer.parseInt(config.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        GUI app = new GUI();
        app.setVisible(true);
        WorkFile.workFile();
        ConnectServer.connect(LOGIN, PASSWORD, HOST, PORT, DIR, getVersion());
        WorkFile.installNewApp();
        label.setText(label.getText() + "Success!\n");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.dispose();
    }

}
