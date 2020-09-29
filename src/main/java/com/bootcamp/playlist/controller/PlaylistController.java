package com.bootcamp.playlist.controller;

import com.bootcamp.playlist.domain.Playlist;
import com.bootcamp.playlist.domain.Track;
import com.bootcamp.playlist.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestParam int userId, @RequestBody Playlist playlist){
        playlist.setUserId(userId);
        playlistService.createPlaylist(playlist);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Void> findById(@PathVariable String playlistId){
        playlistService.findById(playlistId);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Playlist>> findAllByUserId(@RequestParam int userId){
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }



    @PostMapping("/{playlistId}/Track")
    public ResponseEntity<Void> addTrack(@PathVariable String playlistId, Track track){
        Playlist playlist = playlistService.findById(playlistId);
        playlist.addTracks(track);
        playlistService.addTrack(playlistId,playlist);
        return null;
    }

    //@DeleteMapping("/{playlistId}")
    //public  ResponseEntity<Void> removeTrack(@PathVariable String playlistId, Track track){
    //    return null;
    //}

    @DeleteMapping("/{playlistId}/Track")
    public ResponseEntity<Void> removeTrack(@PathVariable String playlistId, @RequestBody Track track){
        playlistService.deleteTrack(playlistId,track);
        return ResponseEntity.ok().build();
    }
}
