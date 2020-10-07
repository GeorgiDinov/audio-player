package eu.deltasource.audioplayer.player;

import eu.deltasource.audioplayer.playable.audioplayable.Author;
import eu.deltasource.audioplayer.playable.audioplayable.Song;
import eu.deltasource.audioplayer.playlist.PlayList;
import eu.deltasource.audioplayer.playlist.SongList;

import static eu.deltasource.audioplayer.playable.audioplayable.AudioPlayableGenre.CLASSIC;
import static eu.deltasource.audioplayer.playable.audioplayable.AudioPlayableGenre.POP;
import static eu.deltasource.audioplayer.playable.audioplayable.AudioPlayableGenre.ROCK;

public class PlayerFactory {

    public static Player createPlayer(String playerType) {
        if (playerType == null) {
            return null;
        } else if (playerType.equalsIgnoreCase("audio")) {
            return createAudioPlayer();
        }
        return null;
    }


    private static Player createAudioPlayer() {

        PlayList songList = new SongList();
        Player player = new AudioPlayer(songList, new PlayListExplorer(songList));

        Song song1 = new Song("FirstSong", new Author("FirstAuthor", 20), CLASSIC, 5);
        Song song2 = new Song("SecondSong", new Author("FirstAuthor", 20), ROCK, 5);
        Song song3 = new Song("ThirdSong", new Author("SecondAuthor", 30), POP, 5);
        Song song4 = new Song("FourthSong", new Author("FirstAuthor", 20), CLASSIC, 5);
        Song song5 = new Song("FifthSong", new Author("SecondAuthor", 30), ROCK, 5);
        Song song6 = new Song("SixthSong", new Author("SecondAuthor", 30), POP, 5);

        player.addNewSong(song1);
        player.addNewSong(song2);
        player.addNewSong(song3);
        player.addNewSong(song4);
        player.addNewSong(song5);
        player.addNewSong(song6);

        return player;
    }

}
