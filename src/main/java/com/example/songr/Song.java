package com.example.songr;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long s_id;
    /*title, a length (in seconds), a trackNumber, and the album on which that song appears.*/
    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    @JoinColumn(name="id")
    Album album = new Album();

    public Song(){

    }

    public Song(String title, int length , int trackNumber){
        this.title=title;
        this.length=length;
        this.trackNumber=trackNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public Album getAlbum() {
        return album;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public long getS_id() {
        return s_id;
    }
}
