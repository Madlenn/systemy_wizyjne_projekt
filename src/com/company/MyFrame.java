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
        super(("Not Hello world"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 1000);
        setLocation(50, 50);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton pobierz = new JButton("pobierz");
        JButton gray = new JButton("gray");
        JButton scale = new JButton("scale");
        JButton rotate = new JButton("rotate");
        JButton blur = new JButton("blur");
        JButton filter2D= new JButton("2D");
        JButton sqrBox= new JButton("sqrBox");
        JButton light= new JButton("light");
        JButton edgeDetection= new JButton("edgeDetection");
        JButton erosion= new JButton("erosion");
        JButton dilate= new JButton("dilate");
        JButton brightness= new JButton("brightness");
        JButton skeletonization= new JButton("skeletonization");
        JButton thresholding= new JButton("thresholding");



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

        JLabel label = new JLabel(); //labelka z oryginalnym obrazkiem
        add(label);


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
                    label.setIcon(new ScaleImageConverter().scaleImage(imagePath,400,300));

                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }
            }
        });
        gray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new GreyImageConverter().toGrayImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        scale.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ScaleImageConverter().scaleImage(imagePath,100,100);
                label.setIcon(image);
            }
        });
        rotate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new RotateImageConverter().rotateImageIcon(imagePath,90);
                label.setIcon(image);
            }
        });
        blur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().blurImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        filter2D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().filter2DImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        sqrBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().sqrBoxFilterImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        light.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().lightFilterImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        edgeDetection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new EdgeDetection().edgeDetection(imagePath);
                label.setIcon(image);
            }
        });
        erosion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ErosionDilation().erosion(imagePath);
                label.setIcon(image);
            }
        });
        dilate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ErosionDilation().dilation(imagePath);
                label.setIcon(image);
            }
        });
        brightness.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Brightness().brightness(imagePath);
                label.setIcon(image);
            }
        });
        skeletonization.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Skeletonization().skeletonization(imagePath);
                label.setIcon(image);
            }
        });
        thresholding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new Thresholding().thresholding(imagePath);
                ImageIcon resizedImage = new ScaleImageConverter().scaleImage(image,400,300);
                label.setIcon(resizedImage);
            }
        });
        setVisible(true);
    }

}

