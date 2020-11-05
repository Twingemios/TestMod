package net.twingemios.testmod;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;
import net.twingemios.testmod.capabilities.ManaCapability;


@EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.FORGE)
public class Events {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerLoggedInEvent event) {
        // Ensure server-side only
        if (event.getPlayer().getEntityWorld().isRemote) {
            return;
        }

        // Fetch Capability
        PlayerEntity player = event.getPlayer();
        IMana cap = Mana.getFromPlayer(player);



        // Initial Setup
        System.out.println("THIS DO BE RUNNIN");
        CompoundNBT data = player.getEntity().getPersistentData();
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(TestMod.MOD_ID, "mana"), new ManaCapability());
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // Fetch & Copy Capability
        PlayerEntity playerOld = event.getOriginal();
        PlayerEntity playerNew = event.getPlayer();
        IMana capOld = Mana.getFromPlayer(playerOld);
        IMana capNew = Mana.getFromPlayer(playerNew);
        capNew.copy(capOld);
    }

}
