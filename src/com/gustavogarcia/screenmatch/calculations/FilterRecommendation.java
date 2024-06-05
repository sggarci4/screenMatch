package com.gustavogarcia.screenmatch.calculations;

public class FilterRecommendation {
    public void filter(Classification classification){
         if (classification.getClassification() >= 4){
             System.out.println("Muy bien evaluado en el momento.");
         } else if (classification.getClassification() >= 2) {
             System.out.println("Popular en el momento.");
         }else {
             System.out.println("Colocálo en la lista para verlo después.");
         }

    }
}
