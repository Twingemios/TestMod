package net.twingemios.testmod.capabilities;

import net.minecraft.entity.player.PlayerEntity;

public interface IMana {

    byte getVersion();
    void setVersion(byte version);

    int getWhiteMana();
    void setWhiteMana(int amount);
    void addWhiteMana(int amount);

    void copy(IMana other);

    //void synchronise(PlayerEntity player);

}
