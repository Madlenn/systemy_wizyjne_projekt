package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MyFrame extends JFrame {
    private String imagePath;

    public MyFrame() {
        //super(("Not Hello world"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(300, 90);
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        setLayout (new FlowLayout());
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

        JLabel label = new JLabel(); //labelka z oryginalnym obrazkiem
        JLabel label2 = new JLabel();
        add(label);
        add(label2);

        pobierz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpeg");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    imagePath = selectedFile.getAbsolutePath();

                    label.setIcon(new ScaleImageConverter(imagePath, 400, 300).scaleImage());
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setVerticalAlignment(JLabel.CENTER);

                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }
            }
        });
        gray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new GreyImageConverter(imagePath, 400, 300).toGrayImageIcon();
                label.setIcon(image);
            }
        });
        scale.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ScaleImageConverter(imagePath, 100, 100).scaleImage();
                label.setIcon(image);
            }
        });
        rotate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new RotateImageConverter(imagePath, 400, 300).rotateImageIcon(90);
                label.setIcon(image);
            }
        });
        blur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter(imagePath, 400, 300).blurImageIcon();
                label.setIcon(image);
            }
        });
        filter2D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter(imagePath, 400, 300).filter2DImageIcon();
                label.setIcon(image);
            }
        });
        sqrBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter(imagePath, 400, 300).sqrBoxFilterImageIcon();
                label.setIcon(image);
            }
        });
        light.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter(imagePath, 400, 300).lightFilterImageIcon();
                label.setIcon(image);
            }
        });
        edgeDetection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new EdgeDetection(imagePath, 400, 300).edgeDetection();
                label.setIcon(image);
            }
        });
        erosion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ErosionDilation(imagePath, 400, 300).erosion();
                label.setIcon(image);
            }
        });
        dilate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ErosionDilation(imagePath, 400, 300).dilation();
                label.setIcon(image);
            }
        });
        brightness.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Brightness(imagePath, 400, 300).brightness();
                label.setIcon(image);
            }
        });
        skeletonization.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Skeletonization(imagePath, 400, 300).skeletonization();
                label.setIcon(image);
            }
        });
        thresholding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Thresholding(imagePath, 400, 300).thresholding();
                label.setIcon(image);
            }
        });
        histogram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Histogram(imagePath, 400, 300).histogram();
                ImageIcon image2 = new Histogram(imagePath, 400, 300).histogram();
                //label.setIcon(image);
                label2.setIcon(image2);
            }
        });
        cc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ColorSpaceConversion(imagePath, 400, 300).cc();
                label.setIcon(image);
            }
        });
        negative.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Negative(imagePath, 400, 300).negative();
                label.setIcon(image);
            }
        });
        setVisible(true);
    }

}

