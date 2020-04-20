package com.starlinks.core.sdk.entity;

import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.score.ScoreEntity;
import com.starlinks.core.api.entity.score.ScoreEntry;
import com.starlinks.core.sdk.entity.score.ScoreEntityImpl;
import com.starlinks.core.sdk.entity.score.ScoreEntryImpl;

public final class ScoreImpl implements ScoreFactory {

    @Override
    public ScoreEntity getNewScore(String title) {
        return new ScoreEntityImpl(title);
    }

    @Override
    public ScoreEntry createLine() {
        return new ScoreEntryImpl();
    }
}
