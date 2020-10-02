package eu.deltasource.audioplayer.playable.audioplayable;

//        1. Създайте клас `Song`. Създайте няколко член-променливи, като прецените сами какъв
//        тип трябва да бъдат
//        - `title` - заглавие на песента
//        - `author` - автор
//        - `genre` - жанр
//        - `timing` - времетраене на песента
//        Напишете метод, който да извежда в конзолата характеристиките на класа.
//        Напишете метод, който да извежда в конзолата форматирано заглавието на песента и
//        автора.

import static eu.deltasource.audioplayer.MyMessages.INVALID_PARAMETER_MESSAGE;

public class Song implements AudioPlayable {


    private String tittle;
    private Person author;
    private AudioPlayableGenre genre;
    private int duration;

    public Song(String tittle, Person author, AudioPlayableGenre genre, int duration) {
        this.tittle = titleValidator(tittle);
        this.author = authorValidator(author);
        this.genre = genreValidator(genre);
        this.duration = durationValidator(duration);
    }

    @Override
    public String getTittle() {
        return this.tittle;
    }

    @Override
    public AudioPlayableGenre getGenre() {
        return this.genre;
    }

    @Override
    public Person getAuthor() {
        return this.author;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public void printDetails() {
        String details = String.format("%s performed by %s ", this.tittle, this.author.getName());
        System.out.println(details);
    }

    private boolean isValidTittle(String tittle) {
        return tittle != null && !tittle.isBlank();
    }

    private String titleValidator(String tittle) {
        if (isValidTittle(tittle)) {
            return tittle;
        }
        System.out.println(INVALID_PARAMETER_MESSAGE);
        throw new IllegalArgumentException("title");
    }

    private boolean isValidAuthor(Person author) {
        return author != null;
    }

    private Person authorValidator(Person author) {
        if (isValidAuthor(author)) {
            return author;
        }
        System.out.println(INVALID_PARAMETER_MESSAGE);
        throw new IllegalArgumentException("author");
    }

    private boolean isValidGenre(AudioPlayableGenre genre) {
        return genre != null;
    }

    private AudioPlayableGenre genreValidator(AudioPlayableGenre genre) {
        if (isValidGenre(genre)) {
            return genre;
        }
        System.out.println(INVALID_PARAMETER_MESSAGE);
        throw new IllegalArgumentException("genre");
    }

    private boolean isValidDuration(int duration) {
        return duration > 0;//todo regex matching
    }

    private int durationValidator(int duration) {
        if (isValidDuration(duration)) {
            return duration;
        }
        System.out.println(INVALID_PARAMETER_MESSAGE);
        throw new IllegalArgumentException("duration");
    }

    @Override
    public String toString() {
        return "Song{" +
                "tittle='" + tittle + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", duration='" + duration + '\'' +
                '}';
    }

}
