package com.starlinks.core.api.entity;

import com.starlinks.core.api.entity.score.ScoreEntity;
import com.starlinks.core.api.entity.score.ScoreEntry;

public interface ScoreFactory {

    ScoreEntity getNewScore(String title);
    ScoreEntry createLine();
}
