package com.starlinks.test.scoreboard;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.entity.ScoreFactory;
import com.starlinks.core.api.entity.score.ScoreEntity;
import com.starlinks.core.api.entity.score.ScoreEntry;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public final class ScoreboardTaskTest extends BukkitRunnable {

    private final ScoreEntity entity;

    public ScoreboardTaskTest(StarAPI api){
        final ScoreFactory factory = api.getScoreFactory();
        final ScoreEntry staticEntry = factory.createLine();
        final ScoreEntry entry = factory.createLine();

        entity = api.getScoreFactory()
                .getNewScore("&eTest&cBoard")
                .addLines(
                        staticEntry.setText("Funny thing! Line 03"),
                        staticEntry.setText("Line 02 should be here"),
                        entry.setFunction(player -> "Looks, your name is " + player.getName())
                );

        runTaskTimerAsynchronously(api.getInstance(), 0, 20);
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(entity::sendTo);
    }
}
