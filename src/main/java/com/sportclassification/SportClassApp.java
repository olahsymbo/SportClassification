package com.sportclassification;

import com.sportclassification.data.DataLoader;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class SportClassApp {

    /**
     * The main method of the application.
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        String data_path = "/src/main/java/com/sportclassification/dataset/train";
        DataLoader dl = new DataLoader();
        String[] data = dl.imageDirectories(data_path);
        List<BufferedImage> allImages = dl.loadImages(data_path);
        System.out.println(allImages);
    }

}
