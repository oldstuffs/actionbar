package io.github.portlek.actionbar.base;

import io.github.portlek.actionbar.api.ActionBarPlayer;
import io.github.portlek.actionbar.api.IActionBar;
import io.github.portlek.actionbar.api.MckActionBar;
import io.github.portlek.actionbar.nms.v1_10_R1.ActionBar1_10_R1;
import io.github.portlek.actionbar.nms.v1_11_R1.ActionBar1_11_R1;
import io.github.portlek.actionbar.nms.v1_12_R1.ActionBar1_12_R1;
import io.github.portlek.actionbar.nms.v1_13_R1.ActionBar1_13_R1;
import io.github.portlek.actionbar.nms.v1_13_R2.ActionBar1_13_R2;
import io.github.portlek.actionbar.nms.v1_14_R1.ActionBar1_14_R1;
import io.github.portlek.actionbar.nms.v1_15_R1.ActionBar1_15_R1;
import io.github.portlek.actionbar.nms.v1_8_R1.ActionBar1_8_R1;
import io.github.portlek.actionbar.nms.v1_8_R2.ActionBar1_8_R2;
import io.github.portlek.actionbar.nms.v1_8_R3.ActionBar1_8_R3;
import io.github.portlek.actionbar.nms.v1_9_R1.ActionBar1_9_R1;
import io.github.portlek.actionbar.nms.v1_9_R2.ActionBar1_9_R2;
import io.github.portlek.versionmatched.VersionMatched;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class ActionBarPlayerEnvelope implements ActionBarPlayer {

    @NotNull
    private final IActionBar actionBar;

    public ActionBarPlayerEnvelope(@NotNull final Player player) {
        this.actionBar = new VersionMatched<>(
            new MckActionBar(),
            ActionBar1_15_R1.class,
            ActionBar1_14_R1.class,
            ActionBar1_13_R2.class,
            ActionBar1_13_R1.class,
            ActionBar1_12_R1.class,
            ActionBar1_11_R1.class,
            ActionBar1_10_R1.class,
            ActionBar1_9_R2.class,
            ActionBar1_9_R1.class,
            ActionBar1_8_R3.class,
            ActionBar1_8_R2.class,
            ActionBar1_8_R1.class
        ).of(Player.class).instance(player);
    }

    @Override
    public void sendActionBar(@NotNull String actionBar) {
        this.actionBar.sendActionBar(actionBar);
    }
}
