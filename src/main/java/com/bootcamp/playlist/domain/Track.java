package com.bootcamp.playlist.domain;

public class Track {
    private String name;
    private String length;
    private String artist;

    public void Track(){
        this.name = "";
        this.length = "";
        this.artist = "";
    }
    public Track(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }

    public String getArtist() {
        return artist;
    }
}
