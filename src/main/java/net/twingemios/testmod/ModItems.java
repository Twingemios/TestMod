package net.twingemios.testmod;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.twingemios.testmod.items.ItemWand;

@EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.MOD)
public class ModItems {

    public static Item wand = new ItemWand("wand");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(wand);
    }

}
