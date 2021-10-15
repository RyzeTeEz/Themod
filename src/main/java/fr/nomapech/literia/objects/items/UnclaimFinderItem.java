package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UnclaimFinderItem extends Item implements IHasModel {
   private static EntityPlayer player;
   private static int dura;
   public static int percents = 0;

   public UnclaimFinderItem(String name, int maxDamage) {
      this.func_185043_a(new ResourceLocation("percent"), new IItemPropertyGetter() {
         @SideOnly(Side.CLIENT)
         public float func_185085_a(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
            return (float)UnclaimFinderItem.percents;
         }
      });
      this.func_77656_e(maxDamage);
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77625_d(1);
      this.func_77637_a((CreativeTabs)null);
      dura = maxDamage;
      ItemsInit.ITEMS.add(this);
   }

   public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
      player = (EntityPlayer)entityIn;
      if (player.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() instanceof UnclaimFinderItem && dura >= 0) {
         --dura;
         stack.func_77972_a(1, player);
      }

      super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
   }

   public boolean func_77616_k(ItemStack stack) {
      return false;
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
