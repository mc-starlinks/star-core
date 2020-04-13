package com.starlinks.core.api.entity.score;

import org.bukkit.entity.Player;

public interface ScoreEntity {

    ScoreEntry createLine();
    void addLine(ScoreEntry... entity);

    void sendTo(Player player);
}
