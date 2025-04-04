package com.pizzashark.speedyeggs;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FeatherParticle extends TextureSheetParticle {
    private final SpriteSet spriteSet;

    protected FeatherParticle(ClientLevel level, double x, double y, double z,
                                double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.spriteSet = spriteSet;
        // Retrieve the sprite from the SpriteSet built via the JSON file.
        this.sprite = spriteSet.get(level.getRandom());
        if (this.sprite == null) {
            System.err.println("FeatherParticle sprite is null! Check that your JSON file (feather_particle.json) " +
                               "and texture (textures/particle/feather.png) are in the correct location and properly formatted.");
        }
        this.gravity = 0.0F;
        this.lifetime = 20; // Particle lasts 20 ticks.
        this.quadSize *= 0.5F; // Adjust scale as needed.
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
