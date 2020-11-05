package net.twingemios.testmod.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class ManaStorage implements Capability.IStorage<IMana>{
    @Nullable
    @Override
    public INBT writeNBT(Capability<IMana> capability, IMana instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("mana", instance.getMana());
        tag.putInt("max_mana", instance.getMaxMana());
        return tag;
    }

    @Override
    public void readNBT(Capability<IMana> capability, IMana instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setMana(tag.getInt("mana"));
        instance.setMaxMana(tag.getInt("max_mana"));
    }
}
