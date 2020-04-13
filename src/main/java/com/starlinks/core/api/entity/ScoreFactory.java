package com.starlinks.core.api.entity;

import com.starlinks.core.api.entity.score.ScoreEntity;

public interface ScoreFactory {

    ScoreEntity getNewScore(String title);
}
