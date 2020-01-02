package br.com.amazing.stomptheyard.web.controller;

import br.com.amazing.stomptheyard.web.output.Music;
import br.com.amazing.stomptheyard.web.output.Playlist;
import java.util.ArrayList;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    @RequestMapping(path = "/playlist", method = RequestMethod.GET)
    public Playlist getPlaylistByCity(
        @RequestParam("city") String city,
        @RequestParam("latitude") Long latitude,
        @RequestParam("longitude") Long longitude
    ) {
        validateParameters(city, latitude, longitude);
        return buildDefaultResponse();
    }

    private void validateParameters(String city, Long latitude, Long longitude) {
        if (city == null && (latitude == null || longitude == null)) {
            throw new IllegalArgumentException("You must specify a valid parameter");
        }
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
