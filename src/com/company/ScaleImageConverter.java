package com.company;

import javax.swing.*;

public class ScaleImageConverter extends ImageConverter {

    public ScaleImageConverter(String path, int width, int height) {
        super(path, width, height);
    }

    public ImageIcon scaleImage() {
        return getResizedImageIcon(new ImageIcon(imagePath),width,height);
    }
}

