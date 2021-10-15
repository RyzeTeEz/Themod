package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import javax.annotation.Nullable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityArrow.PickupStatus;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BowItem extends ItemBow implements IHasModel {
   private String typeOfBow = "";
   private double damage;

   public BowItem(String name, int maxDamage, double damage) {
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77625_d(1);
      this.func_77656_e(maxDamage);
      this.func_77637_a((CreativeTabs)null);
      this.typeOfBow = name;
      this.damage = damage;
      ItemsInit.ITEMS.add(this);
      this.func_185043_a(new ResourceLocation("pulling"), new IItemPropertyGetter() {
         @SideOnly(Side.CLIENT)
         public float func_185085_a(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
            return entityIn != null && entityIn.func_184587_cr() && entityIn.func_184607_cu() == stack ? 1.0F : 0.0F;
         }
      });
   }

   public ItemStack func_185060_a(EntityPlayer player) {
      if (this.func_185058_h_(player.func_184586_b(EnumHand.OFF_HAND))) {
         return player.func_184586_b(EnumHand.OFF_HAND);
      } else if (this.func_185058_h_(player.func_184586_b(EnumHand.MAIN_HAND))) {
         return player.func_184586_b(EnumHand.MAIN_HAND);
      } else {
         for(int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            ItemStack itemstack = player.field_71071_by.func_70301_a(i);
            if (this.func_185058_h_(itemstack)) {
               return itemstack;
            }
         }

         return ItemStack.field_190927_a;
      }
   }

   public float getZoom(EntityLivingBase entity) {
      return (float)(1 - MathHelper.func_76125_a(this.func_77626_a((ItemStack)null) - entity.func_184605_cv(), 0, 20) / 60);
   }

   public static float getArrowVelocity(int charge) {
      float f = (float)charge / 20.0F;
      f = (f * f + f * 2.0F) / 3.0F;
      if (f > 1.0F) {
         f = 1.0F;
      }

      return f;
   }

   public void func_77615_a(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
      if (entityLiving instanceof EntityPlayer) {
         EntityPlayer entityplayer = (EntityPlayer)entityLiving;
         boolean flag = entityplayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantments.field_185312_x, stack) > 0;
         ItemStack itemstack = this.func_185060_a(entityplayer);
         int i = this.func_77626_a(stack) - timeLeft;
         i = ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.func_190926_b() || flag);
         if (i < 0) {
            return;
         }

         if (!itemstack.func_190926_b() || flag) {
            if (itemstack.func_190926_b()) {
               itemstack = new ItemStack(Items.field_151032_g);
            }

            float f = getArrowVelocity(i);
            if ((double)f >= 0.1D) {
               boolean flag1 = entityplayer.field_71075_bZ.field_75098_d || itemstack.func_77973_b() instanceof ItemArrow && ((ItemArrow)itemstack.func_77973_b()).isInfinite(itemstack, stack, entityplayer);
               if (!worldIn.field_72995_K) {
                  ItemArrow itemarrow = (ItemArrow)((ItemArrow)(itemstack.func_77973_b() instanceof ItemArrow ? itemstack.func_77973_b() : Items.field_151032_g));
                  EntityArrow entityarrow = itemarrow.func_185052_a(worldIn, itemstack, entityplayer);
                  entityarrow.func_184547_a(entityplayer, entityplayer.field_70125_A, entityplayer.field_70177_z, 0.0F, f * 3.0F, 1.0F);
                  entityarrow.func_70239_b(this.damage);
                  if (f == 1.0F) {
                     entityarrow.func_70243_d(true);
                  }

                  int j = EnchantmentHelper.func_77506_a(Enchantments.field_185309_u, stack);
                  if (j > 0) {
                     entityarrow.func_70239_b(entityarrow.func_70242_d() + (double)j * 0.5D + 0.5D);
                  }

                  int k = EnchantmentHelper.func_77506_a(Enchantments.field_185310_v, stack);
                  if (k > 0) {
                     entityarrow.func_70240_a(k);
                  }

                  if (EnchantmentHelper.func_77506_a(Enchantments.field_185311_w, stack) > 0) {
                     entityarrow.func_70015_d(100);
                  }

                  stack.func_77972_a(1, entityplayer);
                  if (flag1 || entityplayer.field_71075_bZ.field_75098_d && (itemstack.func_77973_b() == Items.field_185166_h || itemstack.func_77973_b() == Items.field_185167_i)) {
                     entityarrow.field_70251_a = PickupStatus.CREATIVE_ONLY;
                  }

                  worldIn.func_72838_d(entityarrow);
               }

               worldIn.func_184148_a((EntityPlayer)null, entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, SoundEvents.field_187737_v, SoundCategory.PLAYERS, 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
               if (!flag1 && !entityplayer.field_71075_bZ.field_75098_d) {
                  itemstack.func_190918_g(1);
                  if (itemstack.func_190926_b()) {
                     entityplayer.field_71071_by.func_184437_d(itemstack);
                  }
               }

               entityplayer.func_71029_a(StatList.func_188057_b(this));
            }
         }
      }

   }

   public void func_77622_d(ItemStack stack, World worldIn, EntityPlayer playerIn) {
      if (this.typeOfBow.contains("literium")) {
         stack.func_77966_a(Enchantments.field_185309_u, 2);
      } else if (this.typeOfBow.contains("demonite")) {
         stack.func_77966_a(Enchantments.field_185309_u, 2);
      }

   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfBow.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfBow.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
