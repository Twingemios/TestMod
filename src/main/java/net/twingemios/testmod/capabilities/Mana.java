package net.twingemios.testmod.capabilities;

import net.minecraft.entity.player.PlayerEntity;

public class Mana implements IMana{
    private int mana = 10;
    private int maxMana = 100;
    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana=maxMana;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void setMaxMana(int maxMana) {
        this.maxMana=maxMana;
    }

    public static IMana getFromPlayer(PlayerEntity player) {
        return player.getCapability(ManaCapability.CAPABILITY, null).orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!"));
    }
}
