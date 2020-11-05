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

public class Mana implements IMana {

    private int whiteMana;

    public Mana() {

    }

    /**
     * White Mana
     */
    @Override
    public int getWhiteMana() {
        return whiteMana;
    }

    @Override
    public void setWhiteMana(int amount) {
        this.whiteMana = amount;
    }

    @Override
    public void addWhiteMana(int amount) {
        this.whiteMana += amount;
    }

    



    @Override
    public void copy(IMana other) {
        this.setWhiteMana(other.getWhiteMana());
    }

    public static IMana getFromPlayer(PlayerEntity player) {
        return player.getCapability(ManaCapability.CAPABILITY, null).orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!"));
    }

    public static void updateClient(ServerPlayerEntity player, IMana cap) {
        PacketManager.sendTo(player, new SyncManaPacket(player.getEntityId(), (CompoundNBT) ManaCapability.CAPABILITY.writeNBT(cap, null)));
    }

}
