package br.com.amazing.stomptheyard.web.controller;

import br.com.amazing.stomptheyard.usecases.service.PlaylistService;
import br.com.amazing.stomptheyard.web.output.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    private PlaylistService service;

    @Autowired
    public PlaylistController(PlaylistService service) {
        this.service = service;
    }

    @RequestMapping(path = "/playlist", method = RequestMethod.GET)
    public Playlist getPlaylist(@RequestParam("city") String city,
        @RequestParam("latitude") Long latitude, @RequestParam("longitude") Long longitude) {
        validateParameters(city, latitude, longitude);
        return service.getPlaylist(city, latitude, longitude);

//        return buildDefaultResponse();
    }

    private void validateParameters(String city, Long latitude, Long longitude) {
        if (city == null && (latitude == null || longitude == null)) {
            throw new IllegalArgumentException("You must specify a valid parameter");
        }
    }
}
