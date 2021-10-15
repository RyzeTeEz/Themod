package fr.nomapech.literia.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesInit {
   public static void registerRecipes() {
      GameRegistry.addSmelting(BlocksInit.COPPER_ORE, new ItemStack(ItemsInit.COPPER, 1), 5.0F);
      GameRegistry.addSmelting(BlocksInit.TIN_ORE, new ItemStack(ItemsInit.TIN, 1), 5.0F);
      GameRegistry.addSmelting(BlocksInit.ISOLUA_ORE, new ItemStack(ItemsInit.ISOLUA, 1), 5.0F);
   }
}
