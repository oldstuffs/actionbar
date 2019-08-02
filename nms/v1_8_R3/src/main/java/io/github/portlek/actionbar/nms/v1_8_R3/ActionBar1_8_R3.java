package io.github.portlek.actionbar.nms.v1_8_R3;

import io.github.portlek.actionbar.api.IActionBar;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionBar1_8_R3 implements IActionBar {

    @NotNull
    private final Player player;

    public ActionBar1_8_R3(@NotNull Player player) {
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
