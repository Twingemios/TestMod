package net.twingemios.testmod.Input;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.twingemios.testmod.PacketManager;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;
import net.twingemios.testmod.capabilities.ManaCapability;
import net.twingemios.testmod.packets.SyncManaPacket;

public class KeyInputHandler {
    Minecraft mc =  Minecraft.getInstance();

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) throws CommandSyntaxException {
        if (Keybinds.enable.isPressed()) {
            //System.out.println("ENABLE IS PRESSED");
            IMana cap = Mana.getFromPlayer(mc.player);
            cap.setMana(69);
            cap.setMaxMana(100);
            PacketManager.sendToServer(new SyncManaPacket(mc.player.getEntityId(),(CompoundNBT) ManaCapability.CAPABILITY.writeNBT(cap, null)));
        }

        if (Keybinds.disable.isPressed()) {
            IMana cap = Mana.getFromPlayer(mc.player);
            System.out.println("MANA GOES HERE "+cap.getMana());
            System.out.println("MAXMANA GOES HERE "+cap.getMaxMana());
        }
    }
}
