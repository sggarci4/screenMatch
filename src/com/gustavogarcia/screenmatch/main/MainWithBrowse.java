package com.gustavogarcia.screenmatch.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gustavogarcia.screenmatch.exception.ErrorConvertedRuntimeException;
import com.gustavogarcia.screenmatch.models.Pelicula;
import com.gustavogarcia.screenmatch.models.Tittle;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithBrowse {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        List<Tittle> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (true){
            System.out.println("Escriba el nombre de una pelicula: ");
            var reader = scanner.nextLine();
            if (reader.equalsIgnoreCase("salir")){
                break;
            }
            String address = "https://www.omdbapi.com/?apikey=d04c192b&t=" + reader.replace(" ", "+");

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                // Tittle tittle = gson.fromJson(json, Tittle.class);
                TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(titleOmdb);
                Tittle tittle = new Tittle(titleOmdb);
                System.out.println("Converted title: " + tittle);

                titles.add(tittle);


            }catch (NumberFormatException e){
                System.out.println("It happened just an error with: ");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("It happened just an error with the URI.");
            }catch (ErrorConvertedRuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);
        FileWriter movies = new FileWriter("movies.json");
        movies.write(gson.toJson(titles));
        movies.close();
        System.out.println("Process finished.");


    }

}
