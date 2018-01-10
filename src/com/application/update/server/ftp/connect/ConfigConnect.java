package com.application.update.server.ftp.connect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConfigConnect {

    private final static String LOGIN = "";
    private final static String PASSWORD = "";
    private final static String HOST = "files..com";
    private final static int PORT = 21;
    private final static String DIR = "public_html/updates/";
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

    public static void connection() {
        ConnectServer.connect(LOGIN, PASSWORD, HOST, PORT, DIR, getVersion());
    }

}
