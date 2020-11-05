package net.twingemios.testmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.twingemios.testmod.capabilities.ManaCapability;

@EventBusSubscriber(modid = "testmod", bus = EventBusSubscriber.Bus.FORGE)
public class Events {

    @SubscribeEvent
    public static void attachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {
        System.out.println("ATTACK CAPABILITY");
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation("testmod", "magic"), new ManaCapability());
        }
    }
}
