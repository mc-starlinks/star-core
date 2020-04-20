package com.starlinks.core.sdk.entity.score;

import com.starlinks.core.api.entity.score.ScoreEntity;
import com.starlinks.core.api.entity.score.ScoreEntry;
import com.starlinks.core.sdk.StarGear;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class ScoreEntityImpl implements ScoreEntity {

    private final List<ScoreEntry> scoreEntries = new ArrayList<>();

    private final String title;

    @Override
    public ScoreEntity addLines(ScoreEntry... entity) {
        scoreEntries.addAll(Arrays.asList(entity));
        return this;
    }

    @Override
    public void sendTo(Player player) {
        Scoreboard board = getPlayerBoard(player);
        Objective objective = getBoardObjective(player, board);

        final String colouredTitle = StarGear.colourText(title);

        objective.setDisplayName(colouredTitle);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        updateLines(player, objective);

        player.setScoreboard(board);
    }

    private void updateLines(Player player, Objective objective) {
        int actualPosition = scoreEntries.size();

        for (ScoreEntry scoreEntry : scoreEntries) {
            int scoreIndex = actualPosition--;

            String text = scoreEntry.getText() != null ?
                    scoreEntry.getText() :
                    scoreEntry.getLine().onUpdate(player);

            Score score = findEntryObjective(scoreIndex, objective);

            if (score != null) {
                if (score.getEntry().equalsIgnoreCase(text)) continue;
                objective.getScoreboard().resetScores(score.getEntry());
            }

            objective.getScore(text).setScore(scoreIndex);
        }
    }

    private Score findEntryObjective(int index, Objective objective) {
        Scoreboard scoreboard = objective.getScoreboard();
        for (String entry : scoreboard.getEntries()) {
            Score score = objective.getScore(entry);
            if (score.getScore() == index) return score;
        }
        return null;
    }

    private Objective getBoardObjective(Player player, Scoreboard scoreboard) {
        Objective objective = scoreboard.getObjective(player.getName());

        return objective != null ? objective : scoreboard
                .registerNewObjective(player.getName(), "dummy");
    }

    private Scoreboard getPlayerBoard(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        return scoreboard != null ? scoreboard : Bukkit
                .getScoreboardManager()
                .getNewScoreboard();
    }
}
