package eu.deltasource.audioplayer.playable.audioplayable;

public interface AudioPlayable {

    String getTittle();

    AudioPlayableGenre getGenre();

    Person getAuthor();

    String getDuration();

    void getDetails();

}
