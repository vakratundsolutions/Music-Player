package com.music.musicplayer.model;

public class Mp3File {
    private String fileName;
    private String filePath;

    public Mp3File(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }
}