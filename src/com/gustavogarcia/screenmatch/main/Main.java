package com.gustavogarcia.screenmatch.main;

import com.gustavogarcia.screenmatch.calculations.CalculatorOfTime;
import com.gustavogarcia.screenmatch.calculations.FilterRecommendation;
import com.gustavogarcia.screenmatch.models.Episode;
import com.gustavogarcia.screenmatch.models.Pelicula;
import com.gustavogarcia.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pelicula myMovie = new Pelicula("Encanto", 2021);
        myMovie.setReleaseDate(2021);
        myMovie.setMinutesFilm(120);
        myMovie.setPlanAcces(true);

        myMovie.showTechnicalSheet();
        myMovie.evaluate(7.8);
        myMovie.evaluate(10);
        System.out.println(myMovie.getTotalOfTheRatings());
        System.out.println(myMovie.calculatesAverage());

        Serie serie1 = new Serie("La casa del Dragón", 2022);
        serie1.setSeasons(1);
        serie1.setMinutesEpisode(50);
        serie1.setEpisodesBySeasons(10);
        serie1.showTechnicalSheet();
        System.out.println(serie1.getMinutesFilm());

        Pelicula otherMovie = new Pelicula("Matrix", 1998);
        otherMovie.setReleaseDate(1998);
        otherMovie.setMinutesFilm(180);

        otherMovie.showTechnicalSheet();

        CalculatorOfTime calculator = new CalculatorOfTime();
        calculator.sumOfTimesGroupOfTitles(myMovie);
        calculator.sumOfTimesGroupOfTitles(serie1);
        calculator.sumOfTimesGroupOfTitles(otherMovie);
        System.out.println("Tiempo necesario para ver tus titulos favoritos esta vacaciones: "
                + calculator.getTotalTime() + " minutos .");

        FilterRecommendation filterRecommendation = new FilterRecommendation();
        filterRecommendation.filter(myMovie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setName("La casa Targaryer");
        episode.setSerie(serie1);
        episode.setTotalViews(50);
        filterRecommendation.filter(episode);

        var movie2 = new Pelicula("El señor de los Anillos", 2001);
        movie2.setMinutesFilm(180);
        movie2.setReleaseDate(2001);

        ArrayList<Pelicula> listOfMovies = new ArrayList<>();
        listOfMovies.add(movie2);
        listOfMovies.add(myMovie);
        listOfMovies.add(otherMovie);

        System.out.println("Tamaño de la lista: " + listOfMovies.size());
        System.out.println("La primer pelicula es: " + listOfMovies.get(0).getName());

        System.out.println(listOfMovies);
        System.out.println("to String de la pelicula: " + listOfMovies.get(0).toString());





    }
}
