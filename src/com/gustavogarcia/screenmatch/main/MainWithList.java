package com.gustavogarcia.screenmatch.main;

import com.gustavogarcia.screenmatch.models.Pelicula;
import com.gustavogarcia.screenmatch.models.Serie;
import com.gustavogarcia.screenmatch.models.Tittle;

import java.util.*;

public class MainWithList {
    public static void main(String[] args) {
        Pelicula myMovie = new Pelicula("Encanto", 2021);
        Pelicula otherMovie = new Pelicula("Matrix", 1998);
        var movie2 = new Pelicula("El señor de los Anillos", 2001);
        Serie serie1 = new Serie("La casa del Dragón", 2022);

        List<Tittle> tittleArrayList = new LinkedList<>();
        tittleArrayList.add(myMovie);
        myMovie.evaluate(9);
        tittleArrayList.add(otherMovie);
        otherMovie.evaluate(6);
        tittleArrayList.add(movie2);
        movie2.evaluate(10);
        tittleArrayList.add(serie1);

        // Otra forma de realizar el foreach
        // tittleArrayList.forEach(System.out::println);
        for (Tittle item : tittleArrayList){
            System.out.println(item.getName());
            if (item instanceof Pelicula pelicula && pelicula.getClassification() > 2){
                System.out.println(pelicula.getClassification());
            }

        }

        ArrayList<String> listOfArtist = new ArrayList<>();
        listOfArtist.add("Penélope Cruz");
        listOfArtist.add("Antonio Banderas");
        listOfArtist.add("Ricardo Darín");
        System.out.println("Lista no ordenada: " + listOfArtist);

        Collections.sort(listOfArtist);

        System.out.println("Lista ordenada de artista: " + listOfArtist);

        Collections.sort(tittleArrayList);

        System.out.println("Lista de titulos ordenada: " + tittleArrayList);

        tittleArrayList.sort(Comparator.comparing(Tittle::getReleaseDate));

        System.out.println("Lista ordenada por año de lanzamiento: " + tittleArrayList);


    }
}
