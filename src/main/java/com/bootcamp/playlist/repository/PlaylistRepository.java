package com.bootcamp.playlist.repository;

import com.bootcamp.playlist.domain.Playlist;
import com.bootcamp.playlist.domain.Track;
import com.couchbase.client.core.msg.kv.GetRequest;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void insert(Playlist playlist) {

        playlistCollection.insert(playlist.getId(),playlist);
    }


    public Playlist findById(String id) {
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;
    }

    public List<Playlist> findByUserId(int userId) {
        String statement = String.format("Select * from playlist where userId=%d", userId);
        QueryResult result = couchbaseCluster.query(statement);
        return result.rowsAs(Playlist.class);
    }

    public void deleteTrack(String playlistId, Track track) {
        String statement = String.format("delete from playlist p where id=%s, p.tracks.name=%s, p.tracks.length=%s, p.tracks.artist=%s ",playlistId,track.getName(),track.getLength(),track.getArtist());
        QueryResult result = couchbaseCluster.query(statement);

    }

    public void update(String playlistId,Playlist playlist) {
        playlistCollection.replace(playlistId, playlist);
    }
}
