package net.twingemios.testmod;


import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;
import net.twingemios.testmod.capabilities.ManaStorage;

@Mod(TestMod.MOD_ID)
@EventBusSubscriber(modid = TestMod.MOD_ID, bus = Bus.MOD)
public class TestMod {

    public static final String MOD_ID = "testmod";

    public TestMod() {
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "levelhearts.toml");
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana::new);
        PacketManager.register();
    }


}
