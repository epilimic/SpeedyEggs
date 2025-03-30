# Speedy Eggs

**Speedy Eggs** is a Minecraft Forge mod for 1.20.1 that adds a custom item called the **Egg Wand**. This magical wand accelerates the egg-laying process of nearby chickens and provides fun visual effects while in use.

## Overview

With Speedy Eggs, you can:
- **Accelerate Egg Laying:** When you hold down the Egg Wand, it rapidly decreases the egg timer for chickens in a 9×9 area. When a chicken’s timer runs out, it immediately drops an egg.
- **Visual Effects:** While using the Egg Wand, fun particles appear around you.
- **Custom Crafting Recipe:** Craft the Egg Wand using a vanilla shapeless recipe.

## Features

- **Continuous Use State:** The wand remains active as long as the use button is held down.
- **Random Timer Decrement:** Every tick, the wand subtracts a random number of ticks (between 1 and 100) from each chicken’s egg timer.
- **Custom Creative Tab:** The mod registers its own creative tab, making it easy to find the Egg Wand in creative mode.

## Installation

1a. **Download the .jar from the releases page:**
    - https://github.com/epilimic/SpeedyEggs/releases/tag/v1.0
    - Skip to step 3
    
1b. **Compile yourself using Forge 1.20.1:**  
   Ensure you have the correct version of Minecraft Forge installed.

2. **Build the Mod:**  
   Clone the repository, then run:
   ```bash
   ./gradlew build
   ```
   The mod JAR will be generated in the `build/libs/` directory.

## Placement

3. **Place the JAR:**  
   Copy or move the JAR file into your Minecraft `mods` folder.

## Usage

- **Crafting:**  
  Use a crafting table to combine an egg, sugar cane, and a stick to craft the Egg Wand.

- **Egg Wand Activation:**  
  Hold the Egg Wand in your hand and press and hold the use button (usually right-click). While in use, the wand accelerates the egg-laying process of any chickens within a 9×9 area and displays particle effects.

## Recipes

The mod adds a vanilla **shapeless** crafting recipe for the Egg Wand. In a crafting table, place:
- 1 Egg
- 1 Sugar Cane
- 1 Stick

The ingredients can be arranged in any order to produce the Egg Wand.

## Assets

- **Model File:**  
  `assets/speedyeggs/models/item/egg_wand.json`

- **Texture File:**  
  `assets/speedyeggs/textures/item/egg_wand.png`

- **Language File:**  
  `assets/speedyeggs/lang/en_us.json`  
  (Includes the translations for the Egg Wand and the custom creative tab)

## Credits

- **Mod Author:** PizzaShark
- **Inspired by:** SomeBitchIKnow's insatiable desire for more eggs

## License

This mod is released under the wet chicken license. Not watering chickens while using this mod is strictly forbidden.

## Future Plans

- Figure out how to use feathers as particle effects.
- Add more wands with different AOE sizes.
- Expand recipes and functionality.
- Maybe add a secret
