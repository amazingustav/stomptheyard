package br.com.amazing.stomptheyard.usecases.service;

import br.com.amazing.stomptheyard.usecases.connector.RetrofitConnector;
import br.com.amazing.stomptheyard.usecases.connector.RetrofitConnectorFactory;
import br.com.amazing.stomptheyard.web.output.Music;
import br.com.amazing.stomptheyard.web.output.Playlist;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private RetrofitConnectorFactory connector;

    @Autowired
    public PlaylistService(RetrofitConnectorFactory connector) {
        this.connector = connector;
    }

    public Playlist getPlaylist(String city, Long latitude, Long longitude) {
        var connector = this.connector.create();

        return city != null ? getPlaylistFromCity(connector, city)
            : getPlaylistFromCoordinates(connector, latitude, longitude);
    }

    private Playlist getPlaylistFromCity(RetrofitConnector connector, String city) {
        return buildDefaultResponse();
    }

    private Playlist getPlaylistFromCoordinates(RetrofitConnector connector, Long latitude, Long longitude) {
        return buildDefaultResponse();
    }

    private Playlist buildDefaultResponse() {
        var music = new Music.Builder()
            .title("Só os Loucos Sabem")
            .author("Charlie Brown Jr.")
            .genre("Rock")
            .duration(300L)
            .build();

        var musicList = new ArrayList<Music>();
        musicList.add(music);

        return new Playlist("Gustavo", musicList);
    }
}
