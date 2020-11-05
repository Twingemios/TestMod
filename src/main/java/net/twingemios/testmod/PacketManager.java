package net.twingemios.testmod;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.twingemios.testmod.packets.SyncManaPacket;

public class PacketManager {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("testmod", "packetmanager"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void register() {
        int id = 0;
        INSTANCE.registerMessage(id++, SyncManaPacket.class, SyncManaPacket::encode, SyncManaPacket::decode, SyncManaPacket::handle);
    }

    //Client -> Server
    public static void sendToServer(Object msg) {
        INSTANCE.sendToServer(msg);
    }

    //Server -> Client
    public static void sendTo(ServerPlayerEntity player, Object msg) {
        INSTANCE.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }
}
