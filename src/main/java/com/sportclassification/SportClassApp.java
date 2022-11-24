package com.sportclassification;

import com.sportclassification.data.DataLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class SportClassApp {

    /**
     * The main method of the application.
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) throws IOException {
        String data_path = "/src/main/java/com/sportclassification/dataset/train";
        DataLoader dl = new DataLoader(data_path);
        String[] data = dl.imageDirectories();
        List<BufferedImage> allImages = dl.loadImages();
        System.out.println(allImages);
    }

}
