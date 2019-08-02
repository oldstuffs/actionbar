package io.github.portlek.actionbar.nms.v1_13_R2;

import io.github.portlek.actionbar.api.IActionBar;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionBar1_13_R2 implements IActionBar {

    @NotNull
    private final Player player;

    public ActionBar1_13_R2(@NotNull Player player) {
        this.player = player;
    }

    @Override
    public void sendActionBar(@NotNull String actionBar) {
        final IChatBaseComponent actionBarChat = IChatBaseComponent.ChatSerializer.a(
            "{\"text\": \"" + actionBar + "\"}"
        );
        final Packet bar = new PacketPlayOutChat(actionBarChat, ChatMessageType.GAME_INFO);
        final CraftPlayer craftPlayer = (CraftPlayer)player;
        final EntityPlayer entityPlayer = craftPlayer.getHandle();

        entityPlayer.playerConnection.sendPacket(bar);
    }

}
