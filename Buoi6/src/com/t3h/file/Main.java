package com.t3h.file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileManager manager = new FileManager();
//        manager.init();
//        manager.readAllFile(new File("D:/"));
//        manager.write("Hello world\n");
//        manager.read();

        String link = "https://c4-ex-swe.nixcdn.com/PreNCT16/AnhCanEm-ChauKhaiPhongKhangViet-5991192.mp4";
        String path = "D:/T3H/Download/Video.mp4";
        manager.download(link, path);
    }
}
