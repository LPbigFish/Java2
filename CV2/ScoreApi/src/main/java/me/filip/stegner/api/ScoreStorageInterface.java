package me.filip.stegner.api;

import java.util.List;

public interface ScoreStorageInterface {
    void init();

    void save(Score score) throws ScoreException;

    void save(List<Score> scores) throws ScoreException;

    List<Score> load() throws ScoreException;

    void delete(Score score) throws ScoreException;

    void stop();
}
