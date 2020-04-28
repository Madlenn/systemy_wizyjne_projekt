package com.company;

import javax.swing.*;
import java.awt.*;

public class ScaleImageConverter extends ImageConverter {

    public ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon myImage = new ImageIcon(imagePath);
        return scaleImage(myImage, width, height);
    }

    public ImageIcon scaleImage(ImageIcon imageIcon, int width, int height) {
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}

