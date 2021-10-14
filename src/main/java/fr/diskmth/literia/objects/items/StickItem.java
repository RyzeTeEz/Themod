package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class StickItem extends Item implements IHasModel {
   private String typeOfStick = "";

   public StickItem(String name, int MaxDamage) {
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77625_d(1);
      this.typeOfStick = name;
      this.func_77656_e(MaxDamage - 1);
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public ActionResult func_77659_a(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
      ItemStack stack;
      if (this.typeOfStick.contains("heal")) {
         stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
         if (!worldIn.field_72995_K) {
            if (playerIn.func_110143_aJ() == 20.0F) {
               return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
            } else {
               playerIn.func_70690_d(new PotionEffect(MobEffects.field_76432_h, 1, 2));
               stack.func_77972_a(1, playerIn);
               if (!playerIn.field_71075_bZ.field_75098_d) {
                  playerIn.func_184811_cZ().func_185145_a(this, 300);
               }

               return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
            }
         } else {
            return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
         }
      } else if (this.typeOfStick.contains("speed")) {
         stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
         if (!worldIn.field_72995_K) {
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 140, 2));
            stack.func_77972_a(1, playerIn);
            if (!playerIn.field_71075_bZ.field_75098_d) {
               playerIn.func_184811_cZ().func_185145_a(this, 300);
            }

            return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
         } else {
            return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
         }
      } else if (this.typeOfStick.contains("strenght")) {
         stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
         if (!worldIn.field_72995_K) {
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 200, 1));
            stack.func_77972_a(1, playerIn);
            if (!playerIn.field_71075_bZ.field_75098_d) {
               playerIn.func_184811_cZ().func_185145_a(this, 300);
            }

            return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
         } else {
            return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
         }
      } else if (this.typeOfStick.contains("legendary")) {
         stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
         if (!worldIn.field_72995_K) {
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76432_h, 1, 1));
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 140, 2));
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 100, 2));
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76422_e, 160, 1));
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76428_l, 300, 1));
            playerIn.func_70690_d(new PotionEffect(MobEffects.field_76444_x, 2400, 1));
            stack.func_77972_a(1, playerIn);
            if (!playerIn.field_71075_bZ.field_75098_d) {
               playerIn.func_184811_cZ().func_185145_a(this, 600);
            }

            return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
         } else {
            return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
         }
      } else {
         return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
      }
   }

   public boolean func_77616_k(ItemStack stack) {
      return false;
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
