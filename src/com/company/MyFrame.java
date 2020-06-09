package com.company;
compile group: 'net.sourceforge.tess4j', name: 'tess4j', version: '1.3.0'

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;


public class MyFrame extends JFrame {
    private String imagePath;

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(300, 90);
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        setLayout(new FlowLayout());
        JButton pobierz = new JButton("pobierz");
        JButton gray = new JButton("gray");
        JButton scale = new JButton("scale");
        JButton rotate = new JButton("rotate");
        JButton blur = new JButton("blur");
        JButton filter2D = new JButton("2D");
        JButton sqrBox = new JButton("sqrBox");
        JButton light = new JButton("light");
        JButton edgeDetection = new JButton("edgeDetection");
        JButton erosion = new JButton("erosion");
        JButton dilate = new JButton("dilate");
        JButton brightness = new JButton("brightness");
        JButton skeletonization = new JButton("skeletonization");
        JButton thresholding = new JButton("thresholding");
        JButton histogram = new JButton("histogram");
        JButton cc = new JButton("color conversion");
        JButton negative = new JButton("negative");

        add(pobierz);


        JLabel label = new JLabel(); //labelka z oryginalnym obrazkiem

        JLabel label2 = new JLabel();
        add(label);
        add(label2);

        pobierz.addActionListener(e -> {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG files", "jpg", "jpeg");


            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                String extension = getFileExtension(file);
                if (!extension.equals(".jpeg")) {

                    JOptionPane.showMessageDialog(null, "wybrałeś niepoprawny plik, wybierz .jpeg");

                } else {
                    String a = getFileExtension(file);
                    System.out.println(a);
                    File selectedFile = file.getSelectedFile();
                    imagePath = selectedFile.getAbsolutePath();

                    label.setIcon(new ScaleImageConverter(imagePath, 400, 300).scaleImage());
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setVerticalAlignment(JLabel.CENTER);
                    add(gray);
                    add(scale);
                    add(rotate);
                    add(blur);
                    add(filter2D);
                    add(sqrBox);
                    add(light);
                    add(edgeDetection);
                    add(erosion);
                    add(dilate);
                    add(brightness);
                    add(skeletonization);
                    add(thresholding);
                    add(histogram);
                    add(cc);
                    add(negative);
                }

            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("No File Select");
            }
        });
        gray.addActionListener(e -> {
            ImageIcon image = new GreyImageConverter(imagePath, 400, 300).toGrayImageIcon();
            label.setIcon(image);
        });
        scale.addActionListener(e -> {
            ImageIcon image = new ScaleImageConverter(imagePath, 100, 100).scaleImage();
            label.setIcon(image);
        });
        rotate.addActionListener(e -> {
            ImageIcon image = new RotateImageConverter(imagePath, 400, 300).rotateImageIcon(90);
            label.setIcon(image);
        });
        blur.addActionListener(e -> {
            ImageIcon image = new FilterImageConverter(imagePath, 400, 300).blurImageIcon();
            label.setIcon(image);
        });
        filter2D.addActionListener(e -> {
            ImageIcon image = new FilterImageConverter(imagePath, 400, 300).filter2DImageIcon();
            label.setIcon(image);
        });
        sqrBox.addActionListener(e -> {
            ImageIcon image = new FilterImageConverter(imagePath, 400, 300).sqrBoxFilterImageIcon();
            label.setIcon(image);
        });
        light.addActionListener(e -> {
            ImageIcon image = new FilterImageConverter(imagePath, 400, 300).lightFilterImageIcon();
            label.setIcon(image);
        });
        edgeDetection.addActionListener(e -> {
            ImageIcon image = new EdgeDetection(imagePath, 400, 300).edgeDetection();
            label.setIcon(image);
        });
        erosion.addActionListener(e -> {
            ImageIcon image = new ErosionDilation(imagePath, 400, 300).erosion();
            label.setIcon(image);
        });
        dilate.addActionListener(e -> {
            ImageIcon image = new ErosionDilation(imagePath, 400, 300).dilation();
            label.setIcon(image);
        });
        brightness.addActionListener(e -> {
            ImageIcon image = new Brightness(imagePath, 400, 300).brightness();
            label.setIcon(image);
        });
        skeletonization.addActionListener(e -> {
            ImageIcon image = new Skeletonization(imagePath, 400, 300).skeletonization();
            label.setIcon(image);
        });
        thresholding.addActionListener(e -> {
            ImageIcon image = new Thresholding(imagePath, 400, 300).thresholding();
            label.setIcon(image);
        });
        histogram.addActionListener(e -> {
            ImageIcon image = new Histogram(imagePath, 400, 300).histogram();
            ImageIcon image2 = new Histogram(imagePath, 400, 300).histogram();
            //label.setIcon(image);
            label2.setIcon(image2);
        });
        cc.addActionListener(e -> {
            ImageIcon image = new ColorSpaceConversion(imagePath, 400, 300).cc();
            label.setIcon(image);
        });
        negative.addActionListener(e -> {
            ImageIcon image = new Negative(imagePath, 400, 300).negative();
            label.setIcon(image);
        });
        setVisible(true);
    }

    private String getFileExtension(JFileChooser file) {
        String extension = "";
        try {
            if (file != null) {

                String name = file.getSelectedFile().getName();

                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = " ";
        }

        return extension;

    }


/*    private String getFileExtension(JFileChooser file) {
        String extension = "";
        try {
            if (file != null ) {

                String name = file.getSelectedFile().getName();
                System.out.println(name);
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = " ";
        }

        return extension;

    }*/
}

