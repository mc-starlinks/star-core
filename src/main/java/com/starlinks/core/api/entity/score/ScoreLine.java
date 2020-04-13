package com.starlinks.core.api.entity.score;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface ScoreLine {

    String onUpdate(Player player);
}
