package com.sportclassification;

import com.sportclassification.data.DataLoader;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(data));
    }

}
