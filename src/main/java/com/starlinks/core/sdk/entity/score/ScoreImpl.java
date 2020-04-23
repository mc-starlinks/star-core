package com.starlinks.core.sdk.entity.score;

import com.starlinks.core.api.entity.score.ScoreEntity;
import com.starlinks.core.api.entity.score.ScoreEntry;
import com.starlinks.core.api.entity.score.ScoreFactory;

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
