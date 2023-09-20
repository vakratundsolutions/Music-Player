package com.music.musicplayer.model;

public class MusicFile {
    String title;
    String artist;
    private String data;
    private long id;

    public MusicFile(long id, String title, String artist, String data) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
