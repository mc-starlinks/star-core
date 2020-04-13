package com.starlinks.core.sdk.entity.score;

import com.starlinks.core.api.entity.score.ScoreEntry;
import com.starlinks.core.api.entity.score.ScoreLine;
import lombok.Getter;

@Getter
public final class ScoreEntryImpl implements ScoreEntry {

    private String text = null;
    private ScoreLine line = null;

    @Override
    public ScoreEntry setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public ScoreEntry setFunction(ScoreLine line) {
        this.line = line;
        return this;
    }
}
