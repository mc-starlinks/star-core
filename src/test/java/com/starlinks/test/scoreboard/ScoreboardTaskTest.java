package com.starlinks.test.scoreboard;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.entity.score.ScoreFactory;
import com.starlinks.core.api.entity.score.ScoreEntity;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public final class ScoreboardTaskTest extends BukkitRunnable {

    private final ScoreEntity entity;

    public ScoreboardTaskTest(StarAPI api){
        final ScoreFactory factory = api.getScoreFactory();

        entity = api.getScoreFactory()
                .getNewScore("&eTest&cBoard")
                .addLines(
                        factory.createLine().setText("Funny thing! Line 03"),
                        factory.createLine().setText("Line 02 should be here"),
                        factory.createLine().setFunction(player -> {
                            return "Looks, your name is " + player.getName();
                        })
                );

        runTaskTimerAsynchronously(api.getInstance(), 0, 20);
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(entity::sendTo);
    }
}
