package eu.deltasource.audioplayer;

//Тема 2: Audio Player XL2
//        Ще направим същата задача като `Задача 1`, но ще създадем допълнителен клас `Song`.
//        В конструкторите, задайте стойности по подразбиране (вие изберете какви). Избирайте
//        подходящи имена на методите, както и подходящи типове на резултатите. Създайте клас
//        `Application`, който трябва да е стартовия файл на програмата ни.
//        Не забравяйте да оставяте коментари!
//
//        1. Създайте клас `Song`. Създайте няколко член-променливи, като прецените сами какъв
//        тип трябва да бъдат
//        - `title` - заглавие на песента
//        - `author` - автор
//        - `genre` - жанр
//        - `timing` - времетраене на песента
//        Напишете метод, който да извежда в конзолата характеристиките на класа.
//        Напишете метод, който да извежда в конзолата форматирано заглавието на песента и
//        автора.
//
//        2. Създайте клас `AudioPlayer`. Създайте няколко instance променливи, като прецените
//        сами какъв тип трябва да бъдат
//        - `songs` - всички песни
//----------------------------------------------------------------------------------
//        Напишете метод, който да извежда в конзолата характеристиките на класа.

//        Напишете метод, който да стартира изпълнението на песните последователно.

//        Напишете метод, който да спира изпълнението на песните и след последващо
//        стартиране да започват от начало.

//        Напишете метод, който да прави пауза на текущата песен и след последващото
//        стартиране да продължава от същата песен.

//        Напишете метод, който трябва да стартира следваща песен.

//        Напишете метод, който трябва да стартира предишна песен.

//        Напишете метод, който трябва да изпълнява песните разбъркано.

//        Напишете метод, който трябва да изписва в конзолата коя подред е песента, която в
//        момента се изпълнява, както и нейните заглавие и изпълнител.!!!!!!!!!!!!!
//--------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------
//        Напишете метод, който трябва да търси по заглавие и да извежда в конзолата името на
//        изпълнителя, ако е намерено съвпадение и коя подред е.

//        Напишете метод, който трябва да търси по изпълнител и да извежда в конзолата всички
//        негови песни.
//        Напишете метод, който трябва да извежда в конзолата броят на всички песни.
//        Напишете метод, който може да добавя нова песен.
//        Напишете метод, който може да премахва песен.
//-----------------------------------------------------------------------------------------

import eu.deltasource.audioplayer.playable.audioplayable.Author;
import eu.deltasource.audioplayer.playable.audioplayable.Song;
import eu.deltasource.audioplayer.player.AudioPlayer;
import eu.deltasource.audioplayer.player.Player;
import eu.deltasource.audioplayer.playlist.SongList;

import static eu.deltasource.audioplayer.playable.audioplayable.AudioPlayableGenre.CLASSIC;
import static eu.deltasource.audioplayer.playable.audioplayable.AudioPlayableGenre.POP;
import static eu.deltasource.audioplayer.playable.audioplayable.AudioPlayableGenre.ROCK;

public class Application {

    public static void main(String[] args) {

        Player player = new AudioPlayer(new SongList());

        Song song1 = new Song("FirstSong", new Author("FirstAuthor", 20), CLASSIC, 60);
        Song song2 = new Song("SecondSong", new Author("FirstAuthor", 20), ROCK, 60);
        Song song3 = new Song("ThirdSong", new Author("SecondAuthor", 30), POP, 60);
        Song song4 = new Song("FourthSong", new Author("FirstAuthor", 20), CLASSIC, 60);
        Song song5 = new Song("FifthSong", new Author("SecondAuthor", 30), ROCK, 60);
        Song song6 = new Song("SixthSong", new Author("SecondAuthor", 30), POP, 60);
        player.addNewSong(song1);
        player.addNewSong(song2);
        player.addNewSong(song3);
        player.addNewSong(song4);
        player.addNewSong(song5);
        player.addNewSong(song6);


        System.out.println("Printing all songs of FirstAuthor");
        player.findAllByAuthorName("FirstAuthor");
        System.out.println("Size = " + player.getPlaylistSize());

        System.out.print("Searching for song with name Test: ");
        player.printSongByTittle("Test");

        System.out.print("Searching for song with name FirstSong: ");
        player.printSongByTittle("FirstSong");

        if (player.removeSong(song1)) {
            System.out.println("Removing Song: " + song1);
        }
        System.out.println("Size = " + player.getPlaylistSize());

    }

}
