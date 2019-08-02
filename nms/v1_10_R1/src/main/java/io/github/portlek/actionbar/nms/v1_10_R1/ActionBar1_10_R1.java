package io.github.portlek.actionbar.nms.v1_10_R1;

import io.github.portlek.actionbar.api.IActionBar;
import net.minecraft.server.v1_10_R1.EntityPlayer;
import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.Packet;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionBar1_10_R1 implements IActionBar {

    @NotNull
    private final Player player;

    public ActionBar1_10_R1(@NotNull Player player) {
        this.player = player;
    }

    @Override
    public void sendActionBar(@NotNull String actionBar) {
        final IChatBaseComponent actionBarChat = IChatBaseComponent.ChatSerializer.a(
            "{\"text\": \"" + actionBar + "\"}"
        );
        final Packet bar = new PacketPlayOutChat(actionBarChat, (byte)2);
        final CraftPlayer craftPlayer = (CraftPlayer)player;
        final EntityPlayer entityPlayer = craftPlayer.getHandle();

        entityPlayer.playerConnection.sendPacket(bar);
    }

}
