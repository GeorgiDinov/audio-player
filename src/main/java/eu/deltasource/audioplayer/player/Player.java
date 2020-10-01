package eu.deltasource.audioplayer.player;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;
import eu.deltasource.audioplayer.playlist.PlayList;

import java.util.List;

public abstract class Player {

    protected PlayList playList;

    protected Player(PlayList playList) {
        this.playList = playList;
    }

    protected abstract List<AudioPlayable> getAllSongsByAuthorName(String name);

    protected abstract void getSongByTittle(String tittle);

    protected abstract int getPlaylistSize();

    protected abstract void addNewSong(AudioPlayable song);

    protected abstract boolean removeSong(AudioPlayable song);


    //    Напишете метод, който трябва да търси по заглавие и да
    //    извежда в конзолата името на
//        изпълнителя, ако е намерено съвпадение и коя подред е.

//        Напишете метод, който трябва да търси по изпълнител
//        и да извежда в конзолата всички
//        негови песни.

//        Напишете метод, който трябва да извежда в конзолата броят на всички песни.
//        Напишете метод, който може да добавя нова песен.
//        Напишете метод, който може да премахва песен.

}
