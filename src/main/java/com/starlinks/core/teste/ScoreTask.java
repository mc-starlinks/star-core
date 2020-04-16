package com.starlinks.core.teste;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.entity.score.ScoreEntity;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public final class ScoreTask extends BukkitRunnable {

    private final ScoreEntity entity;

    public ScoreTask(StarAPI api){
        entity = api.getScoreFactory().getNewScore("Boscolo guei kkk");

        entity.addLine(
                entity.createLine().setText("Hello World!"),
                entity.createLine().setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!"),
                entity.createLine().setFunction(player -> {
                    return player.getItemInHand().getType().name();
                })
        );

        runTaskTimerAsynchronously(api.getInstance(), 0, 20);
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(entity::sendTo);
    }
}
