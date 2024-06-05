package com.gustavogarcia.screenmatch.main;

public record TitleOmdb(String title, String year, String runtime) {
    @Override
    public String runtime() {
//        StringBuffer runtimeWithoutWords = new StringBuffer();
//        for (int i = 0; i < runtime.length(); i++) {
//            char c =  runtime.charAt(i);
//            if (Character.isDigit(c)){
//                runtimeWithoutWords.append(c);
//            }
//
//        }
//        runtime = runtimeWithoutWords.toString();
        return runtime.replace(" ", "");
    }
}
