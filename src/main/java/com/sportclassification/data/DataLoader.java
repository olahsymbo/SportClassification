package com.sportclassification.data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DataLoader {

    Path root = Paths.get(".").normalize().toAbsolutePath();

    public String[] imageDirectories(String data_path){
        String pathName = root + data_path;
        File file = new File(pathName);
        String[] directories = file.list((dir, name) -> new File(dir, name).isDirectory());
        return directories;
    }

    public List<BufferedImage> loadImages(String data_path){
        String[] data = imageDirectories(data_path);
        List<BufferedImage> allImages = new ArrayList<>();
        for (String datum : data) {
            String full_path = data_path + "/" + datum;
            java.io.FileFilter filter = file -> !file.isHidden() && (file.isDirectory()
                    || (file.getName().endsWith(".jpg")) || (file.getName().endsWith(".png")));

            javaxt.io.Directory directory = new javaxt.io.Directory(full_path);
            directory.getFiles();
            javaxt.io.File[] files;
            files = directory.getFiles(filter, true);
            for (javaxt.io.File file : files) {
                try {
                    BufferedImage img = ImageIO.read(new File(full_path + "/" + file));
                    allImages.add(img);
                    System.out.println(full_path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return allImages;
    }
}
