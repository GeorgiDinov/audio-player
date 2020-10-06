package eu.deltasource.audioplayer.player;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;
import eu.deltasource.audioplayer.playlist.PlayList;

import java.util.Collections;
import java.util.List;

import static eu.deltasource.audioplayer.util.Color.ANSI_CYAN;
import static eu.deltasource.audioplayer.util.Color.ANSI_PURPLE;
import static eu.deltasource.audioplayer.util.MyMessages.*;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PAUSE;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PLAY;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.SPACE;

public class PlayListExplorer {


    private PlayList playList;
    private List<AudioPlayable> songs;

    private AudioPlayable currentSong;
    private int currentSongIndex;
    private int currentSongCurrentDuration;

    private boolean isPlaying;
    private boolean isStopped;
    private boolean isPaused;
    private boolean isShuffled;

    public void setPlayList(PlayList playList) {
        this.playList = playList;
        this.songs = this.playList.findAll();
    }


    public void playAll() {
        this.isPlaying = true;


        if (this.isShuffled) {
            Collections.shuffle(songs);
        }

        for (int i = 0; i < songs.size(); i++) {
            if (isStopped) {
                break;
            }
            currentSong = this.songs.get(i);
            this.currentSongIndex = i;
            this.playSong(currentSong);
        }
        this.isPlaying = false;
    }


    private void playSong(AudioPlayable song) {

        int songDuration = song.getDuration();
        String songTittle = song.getTittle();
        while (songDuration >= 0) {

            if (isPaused) {
                this.currentSongCurrentDuration = songDuration;
                String info = this.outputFormatter(songTittle, songDuration);
                System.out.print(info + PAUSE);
                isStopped = true;
                break;
            }

            String output = this.outputFormatter(songTittle, songDuration);
            System.out.print(output + PLAY + CURSOR_SHIFT);
            songDuration--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception in playSong() method: " + e.getMessage());
            }
        }
    }

    private void playPreviousSong() {
        int nextSongIndex = currentSongIndex - 1;
        AudioPlayable nextSong;
        if (songIndexExists(nextSongIndex)) {
            nextSong = this.songs.get(nextSongIndex);
            playSong(nextSong);
        } else {
            System.out.println(FIRST_SONG_MESSAGE);
        }
    }

    public void playNextSong() {
        int nextSongIndex = currentSongIndex + 1;
        AudioPlayable nextSong;
        if (songIndexExists(nextSongIndex)) {
            nextSong = this.songs.get(nextSongIndex);
            playSong(nextSong);
        } else {
            System.out.println(LAST_SONG_MESSAGE);
        }
    }

    private String outputFormatter(String songTittle, int songDuration) {
        return SPACE + ANSI_PURPLE + songTittle +
                LEFT_DASH + songDuration + RIGHT_DASH + ANSI_CYAN + SPACE;
    }


    private boolean isPlaying() {
        return this.isPlaying;
    }

    private boolean songIndexExists(int index) {
        return index >= 0 && index < this.songs.size();
    }


    public void setStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void setShuffled(boolean isShuffled) {
        this.isShuffled = isShuffled;
    }
}
