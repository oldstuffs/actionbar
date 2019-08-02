package io.github.portlek.actionbar.base;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionBarPlayerOf extends ActionBarPlayerEnvelope {

    public ActionBarPlayerOf(@NotNull final Player player) {
        super(player);
    }

}
