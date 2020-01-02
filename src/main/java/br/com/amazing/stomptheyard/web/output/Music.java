package br.com.amazing.stomptheyard.web.output;

public class Music {
    private final String title;
    private final String author;
    private final String genre;
    private final Long duration;

    public static class Builder {
        private String title;
        private String author;
        private String genre;
        private Long duration;

        public Builder title(String value) {
            this.title = value;
            return this;
        }

        public Builder author(String value) {
            this.author = value;
            return this;
        }

        public Builder genre(String value) {
            this.genre = value;
            return this;
        }

        public Builder duration(Long value) {
            this.duration = value;
            return this;
        }

        public Music build() {
            return new Music(this);
        }
    }

    private Music(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.duration = builder.duration;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Long getDuration() {
        return duration;
    }
}
