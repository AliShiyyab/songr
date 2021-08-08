package com.example.songr;

public class Album {
    private String title;
    private String artist;
    private int songCount;
    private String length;
    private String imageUrl;

    public Album(String title, String artist, int songCount, String length , String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getLength() {
        return length;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
