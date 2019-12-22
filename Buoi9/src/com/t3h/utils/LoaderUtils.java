package com.t3h.utils;

import javax.swing.*;
import java.awt.*;

public class LoaderUtils {
    public static Image getImage(String name) {
        ImageIcon icon = new ImageIcon(
                new LoaderUtils().getClass().getResource(
                        "/images/" + name
                )
        );
        return icon.getImage();
    }
}
