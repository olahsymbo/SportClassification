package com.sportclassification.data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public final class DataLoader {

    public static String[] imageDirectories(String dataPath){
        String pathName = Paths.get(".").normalize().toAbsolutePath() + dataPath;
        File file = new File(pathName);
        return file.list((dir, name) -> new File(dir, name).isDirectory());
    }

    public static List<BufferedImage> loadImages(String dataPath){
        String[] data = imageDirectories(dataPath);
        List<BufferedImage> allImages = new ArrayList<>();
        for (String datum : data) {
            String fullFolderPath = dataPath + "/" + datum;

            File folder = new File(fullFolderPath);
            File[] imageNames = folder.listFiles();   // this guy may generate a NullPointerException (wrap in a try catch and do something like logging or something)
            if(imageNames == null){
                // do something
                continue;   // will go to the next iteration if the current imageNames is null
            }
            for (File image : imageNames) {
                if (image.isFile() && (image.getName().endsWith(".jpg")) || (image.getName().endsWith(".png"))){
                    try {
                        BufferedImage img = ImageIO.read(new File(fullFolderPath + "/" + image.getName()));
                        allImages.add(img);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return allImages;
    }
}