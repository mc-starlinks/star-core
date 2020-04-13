package com.starlinks.core.api.entity.score;

public interface ScoreEntry {

    String getText();
    ScoreLine getLine();

    ScoreEntry setText(String text);
    ScoreEntry setFunction(ScoreLine line);
}
