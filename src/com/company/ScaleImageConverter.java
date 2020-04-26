package com.company;

import javax.swing.*;
import java.awt.*;

public class ScaleImageConverter extends ImageConverter {

    public ImageIcon scaleImage(String imagePath, int width, int height) {

        ImageIcon MyImage = new ImageIcon(imagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }


}

