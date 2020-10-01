package eu.deltasource.audioplayer.player;

//        2. Създайте клас `AudioPlayer`. Създайте няколко instance променливи, като прецените
//        сами какъв тип трябва да бъдат
//        - `songs` - всички песни
//        Напишете метод, който да извежда в конзолата характеристиките на класа.
//        Напишете метод, който да стартира изпълнението на песните последователно.
//        Напишете метод, който да спира изпълнението на песните и след последващо
//        стартиране да започват от начало.
//        Напишете метод, който да прави пауза на текущата песен и след последващото
//        стартиране да продължава от същата песен.
//        Напишете метод, който трябва да стартира следваща песен.
//        Напишете метод, който трябва да стартира предишна песен.
//        Напишете метод, който трябва да изписва в конзолата коя подред е песента, която в
//        момента се изпълнява, както и нейните заглавие и изпълнител.
//        Напишете метод, който трябва да изпълнява песните разбъркано.
//
//        Напишете метод, който трябва да търси по заглавие и да извежда в конзолата името на
//        изпълнителя, ако е намерено съвпадение и коя подред е.
//        Напишете метод, който трябва да търси по изпълнител и да извежда в конзолата всички
//        негови песни.
//        Напишете метод, който трябва да извежда в конзолата броят на всички песни.
//        Напишете метод, който може да добавя нова песен.
//        Напишете метод, който може да премахва песен.

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;
import eu.deltasource.audioplayer.playlist.PlayList;

import java.util.List;

public class AudioPlayer extends Player {

    public AudioPlayer(PlayList playList) {
        super(playList);
    }


    @Override
    protected List<AudioPlayable> getAllSongsByAuthorName(String name) {
        return this.playList.getAllByAuthorName(name);
    }

    @Override
    protected void getSongByTittle(String tittle) {
        int position = this.playList.getPositionByTittle(tittle);
        if (position == -1) {
            System.out.println("Song record not found!");
        }
        AudioPlayable song = this.playList.getAll().get(position);
        String formattedSong = String.format("%d - %s", position + 1, song.getTittle());
        System.out.println(formattedSong);
    }

    @Override
    protected int getPlaylistSize() {
        return this.playList.size();
    }

    @Override
    protected void addNewSong(AudioPlayable song) {
        this.playList.add(song);
    }

    @Override
    protected boolean removeSong(AudioPlayable song) {
        return this.playList.remove(song);
    }

}
