package com.t3h.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FileManager {
    private String path = "D:/T3H/Android/1910E/buoi6.txt";
    private SimpleDateFormat format =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void init() {
        try {
            File f = new File(path);
            boolean isExists = f.exists();
            if (isExists == true) {
//                f.delete();
//                System.out.println("Xoa file thanh cong");
                System.out.println(f.getName());
                SimpleDateFormat format
                        = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String time = format.format(f.lastModified());
                System.out.println(time);
                String size = readableFileSize(f.length());
                System.out.println(size);
            }else {
                f.getParentFile().mkdirs();
                boolean created = f.createNewFile();
                if (created) {
                    System.out.println("Tao file thanh cong");
                }else {
                    System.out.println("Tao file that bai");
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String readableFileSize(long size) {
        if(size <= 0) return "0";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public void readAllFile(File f) {
        File[] files = f.listFiles();
        if (files == null) return;
        for (File file: files) {
            if (file.isDirectory()) {
                readAllFile(file);
            }else {
                System.out.print(file.getName() +"\t");
                System.out.print(format.format(file.lastModified()) + "\t");
                System.out.print(readableFileSize(file.length()));
                System.out.println();
            }
        }
    }

    public void write(String value) {
        try {
            File f = new File(path);
            if (f.exists() == false) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(f, true);
            out.write(value.getBytes());
            out.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void read() {
        try {
            File f = new File(path);
            if (!f.exists()) {
                return;
            }
            FileInputStream in = new FileInputStream(f);
            byte[] b = new byte[1024];
            int count = in.read(b);
            String s = "";
            while (count > 0) {
                s += new String(b, 0, count, "utf-8");
                count = in.read(b);
            }
            in.close();
            System.out.println(s);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void download(String link, String path) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            long total = connection.getContentLengthLong();
            long totalDownloaded = 0;

            byte[] b = new byte[1024];
            int count = in.read(b);
            while (count > 0) {
                totalDownloaded += count;
                int percent = (int) (totalDownloaded * 100 / total);
                System.out.println(percent);
                out.write(b, 0, count);
                count = in.read(b);
            }
            in.close();
            out.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
