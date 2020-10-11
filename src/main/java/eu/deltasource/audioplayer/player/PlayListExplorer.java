package eu.deltasource.audioplayer.player;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;
import eu.deltasource.audioplayer.playable.audioplayable.Song;
import eu.deltasource.audioplayer.playlist.PlayList;

import java.util.Collections;
import java.util.List;

import static eu.deltasource.audioplayer.util.Color.ANSI_CYAN;
import static eu.deltasource.audioplayer.util.Color.ANSI_PURPLE;
import static eu.deltasource.audioplayer.util.MyMessages.CURSOR_SHIFT;
import static eu.deltasource.audioplayer.util.MyMessages.LEFT_DASH;
import static eu.deltasource.audioplayer.util.MyMessages.NO_MORE_SONGS;
import static eu.deltasource.audioplayer.util.MyMessages.RIGHT_DASH;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PAUSE;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PLAY;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.SPACE;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.STOP;

public class PlayListExplorer {


    private PlayList playList;
    private List<AudioPlayable> songs;

    public PlayListExplorer(PlayList playList) {
        this.playList = playList;
    }


    private AudioPlayable currentSong;
    private int currentSongIndex;
    private int currentSongCurrentDuration;

    private boolean isStopped;
    private boolean isPaused;
    private boolean isShuffled;

    private boolean isNextSongWanted;
    private boolean isPreviousSongWanted;


    public void playAll() {
        this.songs = playList.findAll();
        shuffleHandler();
        int songIndex;
        for (songIndex = 0; songIndex < this.songs.size(); songIndex++) {
            if (stopIsOn()) {
                break;
            }
            if (pauseIsOn()) {
                songIndex = this.pausedSongHandler();
            }
            if (this.isNextSongWanted) {
                continue;
            }

            if (this.isPreviousSongWanted) {

            }

            this.currentSong = this.songs.get(songIndex);
            this.currentSongIndex = songIndex;
            this.playSong(this.currentSong);
        }
        printNoMoreSongsMessage(songIndex);
    }

    private void shuffleHandler() {
        if (this.isShuffled) {
            this.isShuffled = false;
            Collections.shuffle(this.songs);
        }
    }

    private boolean stopIsOn() {
        if (this.isStopped) {
            this.isStopped = false;
            printStop();
            return true;
        }
        return false;
    }

    private boolean pauseIsOn() {
        if (this.isPaused) {
            this.isPaused = false;
            return true;
        }
        return false;
    }


    private int pausedSongHandler() {
        this.playSong(this.currentSong);
        int nextSongIndex = this.currentSongIndex + 1;
        if (this.songIndexExists(nextSongIndex)) {
            return nextSongIndex;
        } else {
            return -1;
        }
    }


    private void playSong(AudioPlayable song) {

        int songDuration = song.getDuration();
        String songTittle = song.getTittle();

        while (songDuration >= 0) {

            if (this.isNextSongWanted) {
                this.isNextSongWanted = false;
                break;
            }

            if (this.isPaused) {
                this.currentSongCurrentDuration = songDuration;
                System.out.print(this.outputFormatter(songTittle, songDuration) + PAUSE);
                this.currentSong = this.pausedSongBuilder();
                isStopped = true;
                break;
            }

            System.out.print(this.outputFormatter(songTittle, songDuration) + PLAY + CURSOR_SHIFT);
            songDuration--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception in playSong() method: " + e.getMessage());
            }
        }
    }


    private String outputFormatter(String songTittle, int songDuration) {
        return SPACE + ANSI_PURPLE + songTittle +
                LEFT_DASH + songDuration + RIGHT_DASH + ANSI_CYAN + SPACE;
    }

    private AudioPlayable pausedSongBuilder() {
        return new Song(currentSong.getTittle(), currentSong.getAuthor(),
                currentSong.getGenre(), currentSongCurrentDuration);
    }

    private boolean songIndexExists(int index) {
        return index >= 0 && index < this.songs.size();
    }

    private void printNoMoreSongsMessage(int index) {
        if (index == this.songs.size()) {
            System.out.println(NO_MORE_SONGS);
        }
    }

    private void printStop() {
        if (!this.isPaused) {
            System.out.println(SPACE + STOP);
        }
    }


    public void setIsStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }

    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void setIsShuffled(boolean isShuffled) {
        this.isShuffled = isShuffled;
    }

    public void isNextSongWanted(boolean isNextSongWanted) {
        this.isNextSongWanted = isNextSongWanted;
    }

    public void isPreviousSongWanted(boolean isPreviousSongWanted) {
        this.isPreviousSongWanted = isPreviousSongWanted;
    }

}
