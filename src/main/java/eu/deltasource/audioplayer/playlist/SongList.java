package eu.deltasource.audioplayer.playlist;


import eu.deltasource.audioplayer.playable.audioplayable.AudioPlayable;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongList implements PlayList {


    private List<AudioPlayable> songs;

    public SongList() {
        this.songs = new ArrayList<>();
    }

    public SongList(List<AudioPlayable> songs) {
        this.songs = songs;
    }

    @Override
    public void add(AudioPlayable audioPlayable) {
        if (isValidAudioPlayable(audioPlayable) && !exists(audioPlayable)) {
            this.songs.add(audioPlayable);
        }
    }

    @Override
    public boolean remove(AudioPlayable audioPlayable) {
        if (isValidAudioPlayable(audioPlayable) && exists(audioPlayable)) {
            return this.songs.remove(audioPlayable);
        }
        return false;
    }

    private boolean isValidAudioPlayable(AudioPlayable audioPlayable) {
        return audioPlayable != null;
    }

    private boolean exists(AudioPlayable audioPlayable) {
        return this.songs.contains(audioPlayable);
    }

    @Override
    public int size() {
        return this.songs.size();
    }

    @Override
    public List<AudioPlayable> getAll() {
        return new ArrayList<>(this.songs);
    }

    @Override
    public List<AudioPlayable> getAllByAuthorName(String authorName) {
        return songs.stream()
                .filter(audioPlayable -> audioPlayable.getAuthor().getName().equals(authorName))
                .collect(Collectors.toList());
    }


    @Override
    public AudioPlayable getByTittle(String tittle) {
        Optional<AudioPlayable> audioPlayableOptional;
        audioPlayableOptional = this.songs.stream()
                .findFirst()
                .filter(audioPlayable -> audioPlayable.getTittle().equals(tittle));

        return audioPlayableOptional.orElse(null);
    }

    @Override
    public int getPositionByTittle(String tittle) {
        for (int i = 0; i < this.songs.size(); i++) {
            AudioPlayable audioPlayable = this.songs.get(i);
            if (audioPlayable.getTittle().equals(tittle)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<AudioPlayable> getListIterator() {
        return this.songs.listIterator();
    }
}