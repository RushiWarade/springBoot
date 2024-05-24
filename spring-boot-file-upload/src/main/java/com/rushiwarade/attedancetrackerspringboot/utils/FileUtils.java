package com.rushiwarade.attedancetrackerspringboot.utils;


import org.springframework.stereotype.Component;

@Component
public class FileUtils {

    public  String getFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }

        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        }

        return "";
    }
}
