package com.application.update.server.ftp.connect;

import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static com.application.update.window.GUI.label;

class ConnectServer {

    private final static String SAVE_FILENAME = "iReadNewsUpdate.jar";
    private final static String SAVE_CONFIG = "config.txt";

    static void connect(String LOGIN, String PASSWORD, String HOST, int PORT,
                        String DIR, int CURRENT_VERSION) {

        label.setText(label.getText() + "Create FTP-connection.\n");
        FTPClient ftp = new FTPClient();

        try {
            label.setText(label.getText() + "Create connection.\n");
            ftp.connect(HOST, PORT);
            label.setText(label.getText() + "Logging.\n");
            ftp.login(LOGIN, PASSWORD);
            ftp.enterLocalPassiveMode();

            label.setText(label.getText() + "Move to dir.\n");
            ftp.changeWorkingDirectory(DIR);

            final String FILENAME = ftp.listFiles()[3].getName();
            final String VERSION = FILENAME.split("v")[1].split("\\.")[0];

            if (Integer.parseInt(VERSION) > CURRENT_VERSION) {
                label.setText(label.getText() + "A new version is available.\n");
                label.setText(label.getText() + "Update version.\n");
                ftp.changeWorkingDirectory("/");

                label.setText(label.getText() + "Download files.\n");
                OutputStream outputStream =
                        new BufferedOutputStream(new FileOutputStream(SAVE_FILENAME));
                label.setText(label.getText() + "Update config.\n");
                OutputStream outputStreamConfig =
                        new BufferedOutputStream(new FileOutputStream(SAVE_CONFIG));
                ftp.retrieveFile(DIR + "/" + FILENAME, outputStream);
                ftp.retrieveFile(DIR + "/" + SAVE_CONFIG, outputStreamConfig);
                label.setText(label.getText() + "Save changes.\n");
                outputStreamConfig.close();
                outputStream.close();

                System.out.println("All update download");
            } else {
                label.setText(label.getText() + "No updates available.\n");
                ftp.disconnect();
            }

        } catch (IOException ex) {
            label.setText(label.getText() + "Error occurs in downloading files from ftp Server: " + ex.getMessage());
        } finally {
            try {
                if (ftp.isConnected()) {
                    ftp.logout();
                    ftp.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /*public static void main(String[] args) {

        ConnectServer.connect(LOGIN, PASSWORD, HOST, PORT, DIR, getVersion());

    }*/
}
