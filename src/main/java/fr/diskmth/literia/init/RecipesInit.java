/*    */ package fr.diskmth.literia.init;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ 
/*    */ 
/*    */ public class RecipesInit
/*    */ {
/*    */   public static void registerRecipes() {
/* 10 */     GameRegistry.addSmelting(BlocksInit.COPPER_ORE, new ItemStack(ItemsInit.COPPER, 1), 5.0F);
/* 11 */     GameRegistry.addSmelting(BlocksInit.TIN_ORE, new ItemStack(ItemsInit.TIN, 1), 5.0F);
/* 12 */     GameRegistry.addSmelting(BlocksInit.ISOLUA_ORE, new ItemStack(ItemsInit.ISOLUA, 1), 5.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\init\RecipesInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */