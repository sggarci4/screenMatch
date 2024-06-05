package com.gustavogarcia.screenmatch.calculations;

import com.gustavogarcia.screenmatch.models.Pelicula;
import com.gustavogarcia.screenmatch.models.Serie;
import com.gustavogarcia.screenmatch.models.Tittle;

public class CalculatorOfTime {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void sumOfTimesGroupOfTitles(Tittle tittle){
        this.totalTime += tittle.getMinutesFilm();
    }
}
