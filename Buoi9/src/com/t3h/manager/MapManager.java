package com.t3h.manager;

import com.t3h.models.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MapManager {
    public ArrayList<Map> readMap(String name) {
        ArrayList<Map> maps = new ArrayList<>();
        try {
            File f = new File("src/maps/" + name);
            FileReader fileReader = new FileReader(f);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            int j = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    int bit = Integer.parseInt(line.charAt(i) + "");
                    if (bit == 0) continue;
                    int x = i *  19;
                    int y = j * 19;
                    Map m = new Map(x, y, bit);
                    maps.add(m);
                }
                line = reader.readLine();
                j++;
            }
            reader.close();
            fileReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maps;
    }
}
