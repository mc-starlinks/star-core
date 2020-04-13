package com.starlinks.core.sdk.entity;

import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.score.ScoreEntity;
import com.starlinks.core.sdk.entity.score.ScoreEntityImpl;

public final class ScoreImpl implements ScoreFactory {

    @Override
    public ScoreEntity getNewScore(String title) {
        return new ScoreEntityImpl(title);
    }
}
