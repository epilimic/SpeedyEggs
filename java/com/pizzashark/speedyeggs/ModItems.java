package com.pizzashark.speedyeggs;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpeedyEggsMod.MOD_ID);

    // Register the Egg Wand item (do not assign a creative tab here)
    public static final RegistryObject<Item> EGG_WAND = ITEMS.register("egg_wand",
            () -> new EggWand(new Item.Properties().stacksTo(1).durability(64)));
}
