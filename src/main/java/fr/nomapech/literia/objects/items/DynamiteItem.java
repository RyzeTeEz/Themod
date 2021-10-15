package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.objects.entity.EntityDynamite;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class DynamiteItem extends Item implements IHasModel {
   public DynamiteItem(String name) {
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public ActionResult func_77659_a(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
      ItemStack stack = playerIn.func_184586_b(handIn);
      if (!worldIn.field_72995_K) {
         if (!playerIn.field_71075_bZ.field_75098_d) {
            stack.func_190918_g(1);
         }

         worldIn.func_184148_a((EntityPlayer)null, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, SoundEvents.field_187797_fA, SoundCategory.NEUTRAL, 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
         EntityDynamite entityDynamite = new EntityDynamite(worldIn, playerIn);
         entityDynamite.func_184538_a(playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0F, 1.5F, 1.0F);
         worldIn.func_72838_d(entityDynamite);
         return new ActionResult(EnumActionResult.SUCCESS, stack);
      } else {
         return new ActionResult(EnumActionResult.PASS, stack);
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
