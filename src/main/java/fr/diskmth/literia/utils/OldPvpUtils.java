package fr.diskmth.literia.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class OldPvpUtils {
   public static OldPvpUtils.itemType getItemType(ItemStack itemStack) {
      if (itemStack.func_77973_b().getRegistryName() == null) {
         return OldPvpUtils.itemType.OTHER;
      } else {
         String itemName = itemStack.func_77973_b().getRegistryName().toString();
         if (itemName.contains("sword")) {
            return OldPvpUtils.itemType.SWORD;
         } else {
            return !itemName.equals("minecraft:diamond_axe") && !itemName.equals("minecraft:iron_axe") && !itemName.equals("minecraft:stone_axe") && !itemName.equals("minecraft:golden_axe") && !itemName.equals("minecraft:wooden_axe") ? OldPvpUtils.itemType.OTHER : OldPvpUtils.itemType.AXE;
         }
      }
   }

   public static float getOldDamages(ItemStack itemStack) {
      if (itemStack.func_77973_b().getRegistryName() == null) {
         return 0.0F;
      } else if (getItemType(itemStack) != OldPvpUtils.itemType.AXE) {
         return 0.0F;
      } else {
         String var1 = itemStack.func_77973_b().getRegistryName().toString();
         byte var2 = -1;
         switch(var1.hashCode()) {
         case -1742785710:
            if (var1.equals("minecraft:wooden_axe")) {
               var2 = 4;
            }
            break;
         case -867823961:
            if (var1.equals("minecraft:stone_axe")) {
               var2 = 2;
            }
            break;
         case 467966661:
            if (var1.equals("minecraft:golden_axe")) {
               var2 = 3;
            }
            break;
         case 719534660:
            if (var1.equals("minecraft:iron_axe")) {
               var2 = 1;
            }
            break;
         case 1099257686:
            if (var1.equals("minecraft:diamond_axe")) {
               var2 = 0;
            }
         }

         switch(var2) {
         case 0:
            return 6.0F;
         case 1:
            return 5.0F;
         case 2:
            return 4.0F;
         case 3:
         case 4:
            return 3.0F;
         default:
            return 0.0F;
         }
      }
   }

   public static boolean canBeBlocked(DamageSource damageSource) {
      return damageSource.field_76373_n.equals("mob") || damageSource.field_76373_n.equals("player") || damageSource.field_76373_n.equals("arrow") || damageSource.field_76373_n.equals("explosion");
   }

   public static int booleanToInt(boolean isBlocking) {
      return !isBlocking ? 0 : 1;
   }

   public static enum itemType {
      AXE,
      SWORD,
      OTHER;
   }
}
