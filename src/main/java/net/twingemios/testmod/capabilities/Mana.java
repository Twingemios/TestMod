package net.twingemios.testmod.capabilities;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SEntityPropertiesPacket;
import net.minecraft.world.server.ServerWorld;
import net.twingemios.testmod.PacketManager;
import net.twingemios.testmod.packets.SyncManaPacket;

import java.util.Collections;

public class Mana implements IMana{
    private int mana = 12;
    private int maxMana = 100;
    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana=mana;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void setMaxMana(int maxMana) {
        this.maxMana=maxMana;
    }
    /*
    @Override
    public void synchronise(PlayerEntity player) {
        if (!player.getEntityWorld().isRemote) {
            //SEntityPropertiesPacket packet = new SEntityPropertiesPacket(player.getEntityId(), Collections.singleton(attribute));
            //((ServerWorld) player.getEntityWorld()).getChunkProvider().sendToTrackingAndSelf(player, packet);
        }
    }

     */

    public static IMana getFromPlayer(PlayerEntity player) {
        return player.getCapability(ManaCapability.CAPABILITY, null).orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!"));
    }



    public static void updateClient(ServerPlayerEntity player, IMana cap) {
        PacketManager.sendTo(player, new SyncManaPacket(player.getEntityId(), (CompoundNBT) ManaCapability.CAPABILITY.writeNBT(cap, null)));
    }
}
