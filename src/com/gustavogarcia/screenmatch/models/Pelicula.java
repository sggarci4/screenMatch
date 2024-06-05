package com.gustavogarcia.screenmatch.models;

import com.gustavogarcia.screenmatch.calculations.Classification;

public class Pelicula extends Tittle implements Classification {

    private String director;

    public Pelicula(String name, int releaseDate) {
        super(name, releaseDate);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) (calculatesAverage() / 2);
    }

    @Override
    public String toString() {
        return "Pelicula: " + this.getName() + "( " + this.getReleaseDate() + ")";
    }
}
