package com.letsplay.models;

/**
 * Created by girish on 12/1/17.
 */

public class Song {

    private String songName;
    private String composer;
    private String releaseYear;

    public Song(String songName, String composer, String releaseYear){
        this.songName=songName;
        this.composer=composer;
        this.releaseYear=releaseYear;
    }


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
