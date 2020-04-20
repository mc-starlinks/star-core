package com.starlinks.core.api.entity.score;

import org.bukkit.entity.Player;

public interface ScoreEntity {

    ScoreEntity addLines(ScoreEntry... entity);

    void sendTo(Player player);
}
