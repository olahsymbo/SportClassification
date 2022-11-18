package com.sportclassification.data;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.FieldPosition;

public class DataLoader {

    Path root = Paths.get(".").normalize().toAbsolutePath();

    public String[] imageDirectories(String data_path){
        String pathName = root + data_path;
        File file = new File(pathName);
        String[] directories = file.list((dir, name) -> new File(dir, name).isDirectory());
        return directories;
    }

}
