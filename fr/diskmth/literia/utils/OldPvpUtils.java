/*    */ package fr.diskmth.literia.utils;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.DamageSource;
/*    */ 
/*    */ public class OldPvpUtils
/*    */ {
/*    */   public enum itemType
/*    */   {
/* 10 */     AXE, SWORD, OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public static itemType getItemType(ItemStack itemStack) {
/* 15 */     if (itemStack.func_77973_b().getRegistryName() == null)
/*    */     {
/* 17 */       return itemType.OTHER;
/*    */     }
/*    */     
/* 20 */     String itemName = itemStack.func_77973_b().getRegistryName().toString();
/*    */     
/* 22 */     if (itemName.contains("sword"))
/*    */     {
/* 24 */       return itemType.SWORD;
/*    */     }
/*    */     
/* 27 */     if (itemName.equals("minecraft:diamond_axe") || itemName
/* 28 */       .equals("minecraft:iron_axe") || itemName
/* 29 */       .equals("minecraft:stone_axe") || itemName
/* 30 */       .equals("minecraft:golden_axe") || itemName
/* 31 */       .equals("minecraft:wooden_axe"))
/*    */     {
/* 33 */       return itemType.AXE;
/*    */     }
/*    */     
/* 36 */     return itemType.OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public static float getOldDamages(ItemStack itemStack) {
/* 41 */     if (itemStack.func_77973_b().getRegistryName() == null)
/*    */     {
/* 43 */       return 0.0F;
/*    */     }
/*    */     
/* 46 */     if (getItemType(itemStack) != itemType.AXE)
/*    */     {
/* 48 */       return 0.0F;
/*    */     }
/*    */     
/* 51 */     switch (itemStack.func_77973_b().getRegistryName().toString()) {
/*    */       
/*    */       case "minecraft:diamond_axe":
/* 54 */         return 6.0F;
/*    */       case "minecraft:iron_axe":
/* 56 */         return 5.0F;
/*    */       case "minecraft:stone_axe":
/* 58 */         return 4.0F;
/*    */       case "minecraft:golden_axe":
/*    */       case "minecraft:wooden_axe":
/* 61 */         return 3.0F;
/*    */     } 
/*    */     
/* 64 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean canBeBlocked(DamageSource damageSource) {
/* 69 */     return (damageSource.field_76373_n.equals("mob") || damageSource.field_76373_n
/* 70 */       .equals("player") || damageSource.field_76373_n
/* 71 */       .equals("arrow") || damageSource.field_76373_n
/* 72 */       .equals("explosion"));
/*    */   }
/*    */ 
/*    */   
/*    */   public static int booleanToInt(boolean isBlocking) {
/* 77 */     if (!isBlocking)
/*    */     {
/* 79 */       return 0;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 84 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literi\\utils\OldPvpUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */