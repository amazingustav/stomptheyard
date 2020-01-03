package br.com.amazing.stomptheyard.usecases.service;

import br.com.amazing.stomptheyard.usecases.connector.OpenWeatherConnector;
import br.com.amazing.stomptheyard.usecases.connector.SpotifyConnector;
import br.com.amazing.stomptheyard.usecases.connector.RetrofitConnectorFactory;
import br.com.amazing.stomptheyard.web.output.Music;
import br.com.amazing.stomptheyard.web.output.Playlist;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private SpotifyConnector spotifyConnector;
    private OpenWeatherConnector weatherConnector;

    @Autowired
    public PlaylistService(RetrofitConnectorFactory connector) {
        this.spotifyConnector = connector.createSpotifyConnector();
        this.weatherConnector = connector.createOpenWeatherConnector();
    }

    public Playlist getPlaylist(String city, Long latitude, Long longitude) {
        return city != null ? getPlaylistFromCity(city)
            : getPlaylistFromCoordinates(latitude, longitude);
    }

    private Playlist getPlaylistFromCity(String city) {
        return buildDefaultResponse();
    }

    private Playlist getPlaylistFromCoordinates(Long latitude, Long longitude) {
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
