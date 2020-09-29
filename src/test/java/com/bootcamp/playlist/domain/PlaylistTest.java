package com.bootcamp.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistTest {
    @Test
    public void shouldCreatePlaylistWithUserId() {
        //Arrange
        int userId = 0;
        Playlist sut;
        //Act
        sut = new Playlist("Rock","Turkish Songs", 0,0);
        //Assert
        assertEquals(userId, sut.getUserId());
    }

    @Test
    public void shouldAddTrackToPlayList(){
        //Arrange
        Playlist sut = new Playlist();
        Track track = new Track("Gnossiennes 1-6","16","Erik Satie");
        int trackListLengthBeforeAdd = 0;
        int trackListLengthAfterAdd = 0;

        //Act
        trackListLengthBeforeAdd = sut.getTracks().size();
        sut = new Playlist("Rock","Turkish Songs", 0,0);
        sut.addTracks(track);
        trackListLengthAfterAdd = sut.getTracks().size();
        //Assert
        assertEquals(trackListLengthBeforeAdd,trackListLengthAfterAdd-1);
    }

    @Test
    public void shouldRemoveTrackFromPlaylist(){
        //Arrange
        Playlist sut = new Playlist("Rock","Turkish Songs", 0,0);
        Track track = new Track("Gnossiennes 1-6","","");
        sut.addTracks(track);
        int trackCountBeforeRemove;
        int trackCountAfterRemove;
        //Act
        trackCountBeforeRemove = sut.getTracks().size();
        sut.removeTrack(track);
        trackCountAfterRemove = sut.getTracks().size();
        //Assert
        assertEquals(trackCountBeforeRemove-1,trackCountAfterRemove);
    }




}
