package eu.deltasource.audioplayer.player;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;
import eu.deltasource.audioplayer.playlist.PlayList;

import java.util.Collections;
import java.util.List;

import static eu.deltasource.audioplayer.util.Color.ANSI_CYAN;
import static eu.deltasource.audioplayer.util.Color.ANSI_PURPLE;
import static eu.deltasource.audioplayer.util.Color.ANSI_RED;
import static eu.deltasource.audioplayer.util.Color.ANSI_RESET;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PLAY;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.SPACE;

public class PlayListExplorer {


    private PlayList playList;
    private int currentSong;

    private boolean isPlaying;
    private boolean isStopped;
    private boolean isPaused;
    private boolean isShuffled;

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }


    public void playAll() {
        this.isPlaying = true;
        List<AudioPlayable> songs = this.playList.findAll();

        if (this.isShuffled) {
            Collections.shuffle(songs);
        }
        int i;
        for (i = 0; i < songs.size(); i++) {
            this.currentSong = i;
            if (isStopped) {
                break;
            }
            this.playSong(songs.get(i));
        }
        this.isPlaying = false;
    }


    private void playSong(AudioPlayable song) {

        int songDuration = song.getDuration();
        String songTittle = song.getTittle();

        while (songDuration >= 0) {
            System.out.print(ANSI_CYAN + PLAY + SPACE +
                    ANSI_PURPLE + songTittle +
                    ANSI_RED + " -" + songDuration + "- \r");
            songDuration--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception in playSong() method: " + e.getMessage());
            }
        }
        System.out.print(ANSI_RESET);
    }

    public void playNextSong() {

    }


    private boolean isPlaying() {
        return this.isPlaying;
    }


    public void setStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }

}
