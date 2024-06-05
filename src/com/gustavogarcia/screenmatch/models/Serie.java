package com.gustavogarcia.screenmatch.models;

public class Serie extends Tittle {
    int seasons;
    int episodesBySeasons;
    int minutesEpisode;

    public Serie(String name, int releaseDate) {
        super(name, releaseDate);
    }

    @Override
    public int getMinutesFilm() {
        return seasons * episodesBySeasons * minutesEpisode;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesBySeasons() {
        return episodesBySeasons;
    }

    public void setEpisodesBySeasons(int episodesBySeasons) {
        this.episodesBySeasons = episodesBySeasons;
    }

    public int getMinutesEpisode() {
        return minutesEpisode;
    }

    public void setMinutesEpisode(int minutesEpisode) {
        this.minutesEpisode = minutesEpisode;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getName() + "( " + getReleaseDate() + " )";

    }
}
