package com.application.update.file.work;

import java.io.*;
import static com.application.update.window.GUI.label;

public class WorkFile {

    private final static String CURRENT_APP = "iReadNews.jar";
    private final static String UPDATE_APP = "iReadNewsUpdate.jar";
    private final static String CONFIG_NAME = "config.txt";

    private final static File UPDATE_APP_FILE = new File(UPDATE_APP);
    private final static File CURRENT_APP_FILE = new File(CURRENT_APP);

    public static void workFile() throws IOException {
        File CONFIG_NAME_FILE = new File(CONFIG_NAME);

        if (!CONFIG_NAME_FILE.exists()) {
            label.setText(label.getText() + "Configs not found. Created.\n");
            BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_NAME));
            writer.write("0");
            writer.close();
        }

        if (!CURRENT_APP_FILE.exists()) {
            label.setText(label.getText() + "App not found. Created.\n");
            BufferedWriter writer = new BufferedWriter(new FileWriter(CURRENT_APP));
            writer.write("0");
            writer.close();
        }
    }

    public static void installNewApp() {

        CURRENT_APP_FILE.delete();
        UPDATE_APP_FILE.renameTo(new File(CURRENT_APP));

    }

}
