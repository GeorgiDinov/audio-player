package eu.deltasource.audioplayer.playlist;

import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;

import java.util.List;
import java.util.ListIterator;

public interface PlayList {

    void add(AudioPlayable audioPlayable);

    boolean remove(AudioPlayable audioPlayable);

    int size();

    List<AudioPlayable> getAll();

    List<AudioPlayable> getAllByAuthorName(String authorName);

    AudioPlayable getByTittle(String tittle);

    int getPositionByTittle(String tittle);

    ListIterator<AudioPlayable> getListIterator();

}
