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
//-------------------------------------------------------------------------------------------
//        Напишете метод, който трябва да търси по заглавие и да извежда в конзолата името на
//        изпълнителя, ако е намерено съвпадение и коя подред е.
//        Напишете метод, който трябва да търси по изпълнител и да извежда в конзолата всички
//        негови песни.
//        Напишете метод, който трябва да извежда в конзолата броят на всички песни.
//        Напишете метод, който може да добавя нова песен.
//        Напишете метод, който може да премахва песен.

import eu.deltasource.audioplayer.playlist.PlayList;

public class AudioPlayer extends Player {

    public AudioPlayer(PlayList playList, PlayListExplorer playListExplorer) {
        super(playList, playListExplorer);
    }

    @Override
    public void playAll() {
        this.playListExplorer.playAll();
    }


    @Override
    public void playNext(boolean next) {
        this.playListExplorer.isNextSongWanted(next);
    }

    @Override
    public void playPrevious(boolean previous) {
        this.playListExplorer.isPreviousSongWanted(previous);
    }

    @Override
    public void setStopped(boolean isStopped) {
        this.playListExplorer.setIsStopped(isStopped);
    }

    @Override
    public void setPaused(boolean isPaused) {
        this.playListExplorer.setIsPaused(isPaused);
    }

    @Override
    public void setShuffled(boolean isShuffled) {
        this.playListExplorer.setIsShuffled(isShuffled);
    }

}
