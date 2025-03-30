package com.pizzashark.speedyeggs;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpeedyEggsMod.MOD_ID)
public class SpeedyEggsMod {
    public static final String MOD_ID = "speedyeggs";

    @SuppressWarnings("removal")
    public SpeedyEggsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register item and creative tab deferred registers.
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);
        // Remove custom recipe serializer registration.
        System.out.println("Speedy Eggs mod loaded!");
    }
}
