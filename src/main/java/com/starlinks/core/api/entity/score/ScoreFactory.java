package com.starlinks.core.api.entity.score;

public interface ScoreFactory {

    ScoreEntity getNewScore(String title);
    ScoreEntry createLine();
}
