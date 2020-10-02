package eu.deltasource.audioplayer.playlist;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;

import java.util.List;

public interface PlayList {

    void add(AudioPlayable audioPlayable);

    boolean remove(AudioPlayable audioPlayable);

    int size();

    List<AudioPlayable> findAllByAuthorName(String authorName);

    AudioPlayable findSongByTittle(String tittle);

    List<AudioPlayable> findAll();

    int findSongPosition(AudioPlayable audioPlayable);

}
