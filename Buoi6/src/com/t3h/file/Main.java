package com.t3h.file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileManager manager = new FileManager();
        manager.init();
        manager.readAllFile(new File("D:/"));
    }
}
