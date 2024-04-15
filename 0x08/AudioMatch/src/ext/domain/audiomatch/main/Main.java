package ext.domain.audiomatch.main;

import ext.domain.audiomatch.models.Favorites;
import ext.domain.audiomatch.models.Podcast;
import ext.domain.audiomatch.models.Song;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started");
        System.out.println("-------------------------------------------------");
        Song song1 = new Song();
        song1.setTitle("Come As You Are");
        song1.setArtist("Nirvana");
        song1.setAlbum("MTV Unplugged In New York");
        song1.setGenre("Acoustic");

        Song song2 = new Song();
        song2.setTitle("Black or White");
        song2.setArtist("Michael Jackson");
        song2.setAlbum("Dangerous");
        song2.setGenre("Pop");

        Podcast podcast1 = new Podcast();
        podcast1.setTitle("freeCodeCamp");
        podcast1.setPresenter("Quincy Larson");
        podcast1.setDescription("for learn to code");

        Podcast podcast2 = new Podcast();
        podcast2.setTitle("Café Punto Tech");
        podcast2.setPresenter("Alura Latam");
        podcast2.setDescription("education");

        for (int i = 0; i <= 1000; i++) {
            if (i <= 999) {
                song1.reproduction();
            }
            if (i <= 900) {
                song2.reproduction();
            }
            if (i <= 499) {
                podcast1.reproduction();
            }
            if (i <= 400) {
                podcast2.reproduction();
            }

            if (i <= 899) {
                song1.like();
            }
            if (i <= 700) {
                song2.like();
            }
            if (i <= 399) {
                podcast1.like();
            }
            if (i <= 200) {
                podcast2.like();
            }
        }
        System.out.println("\tSong 1\n\tArtist: " + song1.getArtist());
        System.out.println("\tAlbum: " + song1.getAlbum());
        System.out.println("\tGenre: " + song1.getGenre());
        System.out.println("\tReproductions: " + song1.getReproductions());
        System.out.println("\tLikes: " + song1.getLikes());
        System.out.println("*************************************************");
        System.out.println("\tSong 2\n\tArtist: " + song2.getArtist());
        System.out.println("\tAlbum: " + song2.getAlbum());
        System.out.println("\tGenre: " + song2.getGenre());
        System.out.println("\tReproductions: " + song2.getReproductions());
        System.out.println("\tLikes: " + song2.getLikes());
        System.out.println("*************************************************");
        System.out.println("\tPodcast 1\n\tTitle: " + podcast1.getTitle());
        System.out.println("\tPresenter: " + podcast1.getPresenter());
        System.out.println("\tDescription: " + podcast1.getDescription());
        System.out.println("\tReproductions: " + podcast1.getReproductions());
        System.out.println("\tLikes: " + podcast1.getLikes());
        System.out.println("*************************************************");
        System.out.println("\tPodcast 2\n\tTitle: " + podcast2.getTitle());
        System.out.println("\tPresenter: " + podcast2.getPresenter());
        System.out.println("\tDescription: " + podcast2.getDescription());
        System.out.println("\tReproductions: " + podcast2.getReproductions());
        System.out.println("\tLikes: " + podcast2.getLikes());
        System.out.println("*************************************************");
        Favorites favorites = new Favorites();
        favorites.add(song1);
        favorites.add(song2);
        favorites.add(podcast1);
        favorites.add(podcast2);
        System.out.println("-------------------------------------------------");
        System.out.println("Finished.");
    }
}
