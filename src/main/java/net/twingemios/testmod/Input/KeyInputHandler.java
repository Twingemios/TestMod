package net.twingemios.testmod.Input;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;

public class KeyInputHandler {
    Minecraft mc =  Minecraft.getInstance();

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (Keybinds.enable.isPressed()) {
            System.out.println("ENABLE IS PRESSED");
            IMana cap = Mana.getFromPlayer(mc.player);
            cap.setMana(100);
        }

        if (Keybinds.disable.isPressed()) {
            IMana cap = Mana.getFromPlayer(mc.player);
            System.out.println("STUFF GOES HERE "+cap.getMana());
        }
    }
}
