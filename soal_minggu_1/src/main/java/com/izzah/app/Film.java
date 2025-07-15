package com.izzah.app;

public class Film {
    String judul;
    String genre;
    int durasi;
    double rating;

    public Film(String judul, String genre, int durasi, double rating){
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.rating = rating;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurasi() {
        return durasi;
    }

    public double getRating() {
        return rating;
    }   
}
