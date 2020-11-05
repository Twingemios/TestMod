package net.twingemios.testmod.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ManaStorage implements IStorage<IMana> {

    @Override
    public INBT writeNBT(Capability<IMana> capability, IMana instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putByte("version", instance.getVersion());
        tag.putInt("white_mana", instance.getWhiteMana());
        return tag;
    }

    @Override
    public void readNBT(Capability<IMana> capability, IMana instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setVersion(tag.getByte("version"));
        instance.setWhiteMana(tag.getInt("white_mana"));
    }

}
