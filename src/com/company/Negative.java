package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Negative extends ImageConverter {

    public Negative(String path, int width, int height) {
        super(path, width, height);
    }


    public ImageIcon negative() {

        BufferedImage img = null;
        File f = null;
        try {
            f = new File(imagePath);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        ImageIcon resizedImg = getResizedImageIcon(new ImageIcon(img), width, height);
        //BufferedImage buffered = (BufferedImage) resizedImg.getImage();
        int height = img.getHeight();
        int width = img.getWidth();


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                //subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                //set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }
        return  getResizedImageIcon(new ImageIcon(img),this.width,this.height);


    }


}
