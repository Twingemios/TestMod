package net.twingemios.testmod.items;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.twingemios.testmod.TestMod;
import net.twingemios.testmod.ModItems;
import net.twingemios.testmod.capabilities.IMana;
import net.twingemios.testmod.capabilities.Mana;


public class ItemWand extends Item {

    public ItemWand(String name) {
        super(new Properties().maxStackSize(1).group(ItemGroup.MISC));
        this.setRegistryName(TestMod.MOD_ID, name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        ActionResult<ItemStack> result = new ActionResult<>(ActionResultType.PASS, stack);

        // Make sure Server-side only
        if (world.isRemote) {
            return result;
        }



        // Get capability
        IMana cap = Mana.getFromPlayer(player);

        cap.addWhiteMana(1);
        Mana.updateClient((ServerPlayerEntity) player, cap);


        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

}
