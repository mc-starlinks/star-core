package com.starlinks.core.teste;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.entity.score.ScoreEntity;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public final class ScoreTask extends BukkitRunnable {

    private ScoreEntity entity;

    public ScoreTask(StarAPI instance){
        entity = instance.getScoreFactory().getNewScore("Boscolo guei kkk");

        entity.addLine(
                entity.createLine().setText("Hello World!"),
                entity.createLine().setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!")
        );

        runTaskTimerAsynchronously(instance.getInstance(), 0, 20);
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(entity::sendTo);
    }
}
