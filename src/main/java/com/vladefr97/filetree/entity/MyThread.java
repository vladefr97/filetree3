package com.vladefr97.filetree.entity;

import java.io.File;

public class MyThread implements Runnable{

    File file;

    public MyThread(File file) {
        this.file = file;
    }

    private void printFiles(File file) {
        System.out.println("file:" + file.getAbsolutePath());
        if (file.getName().compareTo("sys") == 0||file.getName().compareTo("proc") == 0) return;
        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                printFiles(subFile);
            }
        }


    }
    @Override
    public void run() {

        printFiles(file);
    }
}