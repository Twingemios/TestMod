package net.twingemios.testmod.Input;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static KeyBinding enable;
    public static KeyBinding disable;

    public static void register(){
        enable = new KeyBinding("Enable",71,"key.categories.misc");
        disable = new KeyBinding("Disable",72,"key.categories.misc");
        ClientRegistry.registerKeyBinding(enable);
        ClientRegistry.registerKeyBinding(disable);
    }
}
