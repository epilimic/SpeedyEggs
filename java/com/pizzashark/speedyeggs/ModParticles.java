package com.pizzashark.speedyeggs;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "speedyeggs");

    public static final RegistryObject<SimpleParticleType> FEATHER =
            PARTICLES.register("feather_particle", () -> new SimpleParticleType(false));
}
