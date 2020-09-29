package com.bootcamp.playlist.domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Playlist {
    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private int userId;
    private int listCount;

    public Playlist() {
        this.listCount += this.listCount;
        this.id = UUID.randomUUID().toString();
        this.name = "playlist"+ this.listCount;
        this.description = "";
        this.followersCount = 0;
        this.tracks = new ArrayList<Track>(Arrays.asList(new Track("hello","from","world")));
        this.trackCount = 0;
        this.userId = 0;
    }
    public Playlist(String playlistName, String description, int followersCount, int userId) {
        this.listCount = this.listCount + 1;
        this.id = UUID.randomUUID().toString();
        this.name = playlistName;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks =  new ArrayList<Track>(Arrays.asList(new Track("hello","from","world")));
        this.trackCount = 0;
        this.userId = userId;
    }
    public void addTracks(Track track) {
        this.tracks.add(track);
    }
    public int getUserId() {
        return this.userId;
    }
    public List<Track> getTracks() {
        return this.tracks;
    }

    public void removeTrack(Track track) {
        this.tracks.remove(track);
    }

    public String getId() {
        return this.id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public int getListCount() {
        return listCount;
    }
}
