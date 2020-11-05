package net.twingemios.testmod;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.twingemios.testmod.Input.KeyInputHandler;
import net.twingemios.testmod.Input.Keybinds;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;
import net.twingemios.testmod.capabilities.ManaCapability;
import net.twingemios.testmod.capabilities.ManaStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("testmod")
public class TestMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TestMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana::new);
        Keybinds.register();
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
    }

    @SubscribeEvent
    public void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
        event.addCapability(new ResourceLocation("testmod", "magic"), new ManaCapability());
    }


}
