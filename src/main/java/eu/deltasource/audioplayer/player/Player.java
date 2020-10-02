package eu.deltasource.audioplayer.player;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;
import eu.deltasource.audioplayer.playlist.PlayList;

import java.util.List;

import static eu.deltasource.audioplayer.MyMessages.NO_RECORDS_FOUND;
import static eu.deltasource.audioplayer.MyMessages.SONG_NOT_FOUND;

public abstract class Player {

    protected PlayList playList;

    protected Player(PlayList playList) {
        this.playList = playList;

    }


    public void findAllByAuthorName(String authorName) {
        List<AudioPlayable> list = this.playList.findAllByAuthorName(authorName);
        if (!list.isEmpty()) {
            list.forEach(System.out::println);
        } else {
            System.out.println(NO_RECORDS_FOUND);
        }
    }

    public void printSongByTittle(String tittle) {
        AudioPlayable song = this.playList.findSongByTittle(tittle);
        int position = -1;
        if (song != null) {
            position = this.playList.findSongPosition(song);
        }
        if (position != -1) {
            String formattedSong = String.format("%d. %s", position + 1, song.getTittle());
            System.out.println(formattedSong);
        } else {
            System.out.println(SONG_NOT_FOUND);
        }

    }

    public int getPlaylistSize() {
        return this.playList.size();
    }

    public void addNewSong(AudioPlayable song) {
        this.playList.add(song);
    }

    public boolean removeSong(AudioPlayable song) {
        return this.playList.remove(song);
    }

    public List<AudioPlayable> findAll() {
        return this.playList.findAll();
    }

}
