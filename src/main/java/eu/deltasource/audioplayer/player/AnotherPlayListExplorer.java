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
import static eu.deltasource.audioplayer.util.MyMessages.RIGHT_DASH;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PAUSE;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.PLAY;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.SPACE;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.STOP;

public class AnotherPlayListExplorer {

    PlayList playList;

    List<AudioPlayable> songs;
    AudioPlayable currentSong;
    int currentSongDuration;
    int currentSongIndex;
    int firstSongIndex = 0;

    boolean isShuffled;
    boolean isStopped;
    boolean isPaused;


    public AnotherPlayListExplorer(PlayList playList) {
        this.playList = playList;
    }

    public void prepareSongsForExecution() {
        this.isStopped = false;
        this.songs = playList.findAll();
        if (this.isShuffled) {
            this.isShuffled = false;
            Collections.shuffle(this.songs);
        }
    }

    public void playAllShuffled() {
        this.isShuffled = true;
        this.playAll(this.firstSongIndex);
    }

    public void playAll(int fromIndex) {
        this.prepareSongsForExecution();
        for (int i = fromIndex; i < this.songs.size(); i++) {
            if (this.isStopped) {
                this.stopMessage();
                break;
            }
            if (this.isPaused) {
                this.pausedSongMessage();
                break;
            }
            this.currentSong = this.songs.get(i);
            this.currentSongIndex = i;
            this.playSong(this.currentSong);
        }
    }

    public void pauseSong() {
        this.isPaused = true;
    }

    public void playPausedSong() {
        if (this.isPaused) {
            this.isPaused = false;
            this.currentSong = this.pausedSongBuilder();
            playAll(this.currentSongIndex);
        }
    }

    public void playPreviousSong() {

    }

    public void playNextSong() {

    }


    private void playSong(AudioPlayable song) {

        int songDuration = song.getDuration();
        String songTittle = song.getTittle();

        while (songDuration >= 0) {
            System.out.print(this.outputFormatter(songTittle, songDuration) + PLAY + CURSOR_SHIFT);
            this.currentSongDuration = songDuration;
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

    private void pausedSongMessage() {
        System.out.println(outputFormatter(currentSong.getTittle(), currentSongDuration) + SPACE + PAUSE);
    }

    private void stopMessage() {
        System.out.print(SPACE + STOP);
    }

    private AudioPlayable pausedSongBuilder() {
        return new Song(currentSong.getTittle(), currentSong.getAuthor(),
                currentSong.getGenre(), currentSongDuration);
    }

    private void printInfo() {
        System.out.println(currentSong + SPACE + currentSongIndex + SPACE + currentSongDuration);
    }


    public static void main(String[] args) {

        Player player = PlayerFactory.createPlayer("audio");
        AnotherPlayListExplorer explorer = new AnotherPlayListExplorer(player.playList);
        explorer.playAllShuffled();
    }

}
