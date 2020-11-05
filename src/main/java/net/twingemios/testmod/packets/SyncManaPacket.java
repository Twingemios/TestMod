package net.twingemios.testmod.packets;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;
import net.twingemios.testmod.capabilities.ManaCapability;

import java.util.function.Supplier;

public class SyncManaPacket {

    private final CompoundNBT nbt;

    public SyncManaPacket(int entityId, CompoundNBT nbt) {
        // Add entity id
        nbt.putInt("entityid", entityId);
        this.nbt = nbt;
    }

    private SyncManaPacket(CompoundNBT nbt) {
        this.nbt = nbt;
    }

    public static void encode(SyncManaPacket msg, PacketBuffer buff) {
        buff.writeCompoundTag(msg.nbt);
    }

    public static SyncManaPacket decode(PacketBuffer buff) {
        return new SyncManaPacket(buff.readCompoundTag());
    }

    public static void handle(SyncManaPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Fetch Capability
            PlayerEntity player = (PlayerEntity) Minecraft.getInstance().world.getEntityByID(msg.nbt.getInt("entityid"));
            IMana cap = Mana.getFromPlayer(player);

            // Read NBT Data into Capability
            ManaCapability.CAPABILITY.readNBT(cap, null, msg.nbt);
        });
        ctx.get().setPacketHandled(true);
    }

}
