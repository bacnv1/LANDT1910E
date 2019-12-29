package com.t3h.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LoaderUtils {
    public static Image getImage(String name) {
        ImageIcon icon = new ImageIcon(
                new LoaderUtils().getClass().getResource(
                        "/images/" + name
                )
        );
        return icon.getImage();
    }

    public static void playSound(String name) {
        try {
            File f = new File("src/sounds/" + name);
            Clip clip = AudioSystem.getClip();
            AudioInputStream stream = AudioSystem.getAudioInputStream(f);
            clip.open(stream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
