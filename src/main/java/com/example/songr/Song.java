package com.example.songr;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long s_id;
    /*title, a length (in seconds), a trackNumber, and the album on which that song appears.*/
    private String title;
    private Long length;
    private Long trackNumber;

    @ManyToOne
    @JoinColumn(name="id")
    Album album = new Album();

    public Song(){

    }

    public Song(String title, Long length , Long trackNumber){
        this.title=title;
        this.length=length;
        this.trackNumber=trackNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setTrackNumber(Long trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public Album getAlbum() {
        return album;
    }

    public Long getLength() {
        return length;
    }

    public Long getTrackNumber() {
        return trackNumber;
    }

    public long getS_id() {
        return s_id;
    }
}
