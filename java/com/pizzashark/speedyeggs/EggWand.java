package com.pizzashark.speedyeggs;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

/**
 * EggWand is a custom item that, when continuously used (held down),
 * accelerates nearby chickens' egg-laying rate and spawns particles.
 *
 * Now, each tick subtracts a random number of ticks (between 1 and 100) from each chicken's egg timer.
 * When the timer reaches 0 or less, the chicken spawns an egg and its timer is reset.
 * Additionally, every 10 ticks (~0.5 seconds), a chat message is sent to show the egg timer for the first chicken.
 */
public class EggWand extends Item {

    private final double accelerationFactor;
    private static final double DEFAULT_EGG_INTERVAL = 8400; // 7 minutes in ticks
    private static final Map<Chicken, Long> chickenEggTimers = new WeakHashMap<>();
    private static final Random random = new Random();

    public EggWand(Properties properties, double accelerationFactor) {
        super(properties);
        this.accelerationFactor = accelerationFactor;
    }

    public EggWand(Properties properties) {
        this(properties, 0.5);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Start continuous use
        player.startUsingItem(hand);
        //player.sendSystemMessage(Component.literal("Egg Wand activated!"));
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);

        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;
        if (!stack.equals(player.getUseItem())) return;

        BlockPos center = getTargetBlockPos(player, level);
        if (center == null) center = player.blockPosition();

        if (!level.isClientSide) {
            AABB effectArea = new AABB(center).inflate(4); // 9x9 area
            List<Chicken> chickens = level.getEntitiesOfClass(Chicken.class, effectArea);
            double baseInterval = DEFAULT_EGG_INTERVAL * accelerationFactor;

            for (Chicken chicken : chickens) {
                Long remaining = chickenEggTimers.get(chicken);
                if (remaining == null) {
                    long initialDelay = (long) (baseInterval * (0.9 + 0.2 * random.nextDouble()));
                    chickenEggTimers.put(chicken, initialDelay);
                    remaining = initialDelay;
                }
                // Subtract a random number of ticks between 1 and 100.
                long decrement = 1 + random.nextInt(100);
                remaining -= decrement;
                chickenEggTimers.put(chicken, remaining);

                if (remaining <= 0) {
                    chicken.spawnAtLocation(Items.EGG);
                    long newDelay = (long) (baseInterval * (0.9 + 0.2 * random.nextDouble()));
                    chickenEggTimers.put(chicken, newDelay);
                }
            }
            // Every 10 ticks (~0.5 seconds), output the egg timer for the first chicken.
            //if (!chickens.isEmpty() && level.getGameTime() % 10 == 0) {
            //    Chicken firstChicken = chickens.get(0);
            //    Long rem = chickenEggTimers.get(firstChicken);
            //    if (rem != null) {
            //        player.sendSystemMessage(Component.literal("Egg Timer: " + rem + " ticks remaining"));
            //    }
            //}
        } else {
            // CLIENT SIDE: Only spawn particles (no debug chat message now).
            for (int i = 0; i < 5; i++) {
                double offsetX = (level.random.nextDouble() - 0.5) * 9;
                double offsetY = level.random.nextDouble() * 2;
                double offsetZ = (level.random.nextDouble() - 0.5) * 9;
                double x = center.getX() + 0.5 + offsetX;
                double y = center.getY() + 1 + offsetY;
                double z = center.getZ() + 0.5 + offsetZ;
                level.addParticle(ParticleTypes.CLOUD, x, y, z, 0, -0.1, 0);
            }
        }
    }

    private BlockPos getTargetBlockPos(Player player, Level level) {
        HitResult hit = player.pick(20.0D, 0.0F, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            return new BlockPos((int) hit.getLocation().x, (int) hit.getLocation().y, (int) hit.getLocation().z);
        }
        return null;
    }
}
