package net.twingemios.testmod.capabilities;

import net.minecraft.entity.player.PlayerEntity;

public interface IMana {
    int getMana();

    void setMana(int v1);

    int getMaxMana();

    void setMaxMana(int v1);

    //void synchronise(PlayerEntity player);
}
