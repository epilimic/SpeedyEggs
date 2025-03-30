package com.pizzashark.speedyeggs;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpeedyEggsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SPEEDY_EGGS_TAB = CREATIVE_TABS.register("speedy_eggs_tab", () ->
        CreativeModeTab.builder()
            .title(Component.translatable("item_group." + SpeedyEggsMod.MOD_ID + ".speedy_eggs_tab"))
            .icon(() -> new ItemStack(ModItems.EGG_WAND.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.EGG_WAND.get());
            })
            .build()
    );
}
