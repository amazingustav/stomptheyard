package br.com.amazing.stomptheyard.web.output;

import java.util.List;

public class Playlist {
    private final String author;
    private String description;
    private final List<Music> musics;

    public Playlist(String author, List<Music> musics) {
        this.author = author;
        this.musics = musics;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public List<Music> getMusics() {
        return musics;
    }
}
