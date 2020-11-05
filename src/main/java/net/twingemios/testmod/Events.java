package net.twingemios.testmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;
import net.twingemios.testmod.capabilities.ManaCapability;

@EventBusSubscriber(modid = "testmod", bus = EventBusSubscriber.Bus.FORGE)
public class Events {

    @SubscribeEvent
    public static void attachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation("testmod", "magic"), new ManaCapability());
        }
    }
    /*
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        if (event.getPlayer().getEntityWorld().isRemote) {
            return;
        }

        PlayerEntity player = event.getPlayer();
        IMana cap = Mana.getFromPlayer(player);

        CompoundNBT data = player.getEntity().getPersistentData();

        System.out.println("STRING STUFF "+data.toString());

        CompoundNBT tag = data.getCompound("testmod");
        cap.setMana(tag.getInt("mana"));
        cap.setMaxMana(tag.getInt("max_mana"));

        data.remove("testmod");

    }

     */
}
