package eu.deltasource.audioplayer.playable.audioplayable;

public interface AudioPlayable {

    String getTittle();

    AudioPlayableGenre getGenre();

    Person getAuthor();

    int getDuration();

    void printDetails();

}
