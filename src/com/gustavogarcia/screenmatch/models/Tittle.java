package com.gustavogarcia.screenmatch.models;

import com.google.gson.annotations.SerializedName;
import com.gustavogarcia.screenmatch.main.TitleOmdb;
import com.gustavogarcia.screenmatch.exception.ErrorConvertedRuntimeException;

public class Tittle implements Comparable<Tittle> {
    private String name;
    private int releaseDate;
    private int minutesFilm;
    private boolean planAcces;
    private double sumOfTheRatings;
    private int totalOfTheRatings;

    public Tittle(String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Tittle(TitleOmdb titleOmdb) {
        this.name = titleOmdb.title();
        this.releaseDate = Integer.valueOf(titleOmdb.year());
        //this.minutesFilm = Integer.valueOf(titleOmdb.runtime().substring(0, 3));
        if (titleOmdb.runtime().contains("N/A")){
            throw new ErrorConvertedRuntimeException("It couldn't converted the runtime " +
                    "because contains \"N/A\"");
        }
        StringBuffer runtimeWithoutWords = new StringBuffer();
        for (int i = 0; i < titleOmdb.runtime().length(); i++) {
            char c =  titleOmdb.runtime().charAt(i);
            if (Character.isDigit(c)){
                runtimeWithoutWords.append(c);
            }

        }
        this.minutesFilm = Integer.valueOf(runtimeWithoutWords.toString());
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public int getMinutesFilm() {
        return minutesFilm;
    }

    public boolean isPlanAcces() {
        return planAcces;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMinutesFilm(int minutesFilm) {
        this.minutesFilm = minutesFilm;
    }

    public void setPlanAcces(boolean planAcces) {
        this.planAcces = planAcces;
    }

    public int getTotalOfTheRatings(){
        return totalOfTheRatings;
    }
    public void showTechnicalSheet (){
        System.out.println("La pelicula es: " + name);
        System.out.println("Fecha de lanzamiento: " + releaseDate);
        System.out.println("Duración en minutos: " + getMinutesFilm());

    }

    public void evaluate(double rating){
        sumOfTheRatings += rating;
        totalOfTheRatings++;
    }
    public double calculatesAverage(){
        return  sumOfTheRatings / totalOfTheRatings;
}

    @Override
    public int compareTo(Tittle otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "(Title: " + name +
                ", Year: " + releaseDate +
                ", Minutes film: " + minutesFilm + ")";
    }
}
