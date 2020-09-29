package com.bootcamp.playlist.service;

import com.bootcamp.playlist.domain.Playlist;
import com.bootcamp.playlist.domain.Track;
import com.bootcamp.playlist.repository.PlaylistRepository;
import com.couchbase.client.java.kv.GetResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void createPlaylist(Playlist playlist){
        playlistRepository.insert(playlist);
    }

    public Playlist findById(String Id){
        return playlistRepository.findById(Id);
    }

    public List<Playlist> findAllByUserId(int userId) {
        return playlistRepository.findByUserId(userId);
    }

    public void deleteTrack(String playlistId, Track track) {
        playlistRepository.deleteTrack(playlistId, track);
    }

    public void addTrack(String playlistId,Playlist playlist) {
        playlistRepository.update(playlistId,playlist);
    }
}
