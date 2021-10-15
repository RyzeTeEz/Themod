package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorItem extends ItemArmor implements IHasModel {
   private String typeOfArmor = "";

   public ArmorItem(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
      super(materialIn, renderIndexIn, equipmentSlotIn);
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.typeOfArmor = name;
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
      ItemStack helmet = player.func_184582_a(EntityEquipmentSlot.HEAD);
      ItemStack chestplate = player.func_184582_a(EntityEquipmentSlot.CHEST);
      ItemStack legging = player.func_184582_a(EntityEquipmentSlot.LEGS);
      ItemStack boots = player.func_184582_a(EntityEquipmentSlot.FEET);
      if (!world.field_72995_K) {
         try {
            if ((helmet.func_77973_b() == ItemsInit.LITERIUM_HELMET || helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET) && player.func_70660_b(Potion.func_188412_a(16)).func_76459_b() < 220) {
               player.func_70690_d(new PotionEffect(MobEffects.field_76439_r, 300, 0));
            }

            if ((boots.func_77973_b() == ItemsInit.LITERIUM_BOOTS || boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS) && player.func_70660_b(Potion.func_188412_a(1)).func_76459_b() < 220) {
               player.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 300, 0));
            }

            if (helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET && chestplate.func_77973_b() == ItemsInit.DEMONITE_CHESTPLATE && legging.func_77973_b() == ItemsInit.DEMONITE_LEGGING && boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS && player.func_70660_b(Potion.func_188412_a(14)).func_76459_b() < 220) {
               player.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 300, 0));
            }
         } catch (NullPointerException var9) {
            if (helmet.func_77973_b() == ItemsInit.LITERIUM_HELMET || helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET) {
               player.func_70690_d(new PotionEffect(MobEffects.field_76439_r, 300, 0));
            }

            if (boots.func_77973_b() == ItemsInit.LITERIUM_BOOTS || boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS) {
               player.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 300, 0));
            }

            if (helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET && chestplate.func_77973_b() == ItemsInit.DEMONITE_CHESTPLATE && legging.func_77973_b() == ItemsInit.DEMONITE_LEGGING && boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS) {
               player.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 300, 0));
            }
         }
      }

   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfArmor.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER) {
         return true;
      } else if (this.typeOfArmor.contains("tin") && repair.func_77973_b() == ItemsInit.TIN) {
         return true;
      } else if (this.typeOfArmor.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA) {
         return true;
      } else if (this.typeOfArmor.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfArmor.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE;
      }
   }

   public void func_77622_d(ItemStack stack, World worldIn, EntityPlayer playerIn) {
      if (this.typeOfArmor.contains("demonite_helmet")) {
         stack.func_77966_a(Enchantments.field_180310_c, 4);
         stack.func_77966_a(Enchantments.field_77329_d, 6);
      } else if (this.typeOfArmor.contains("demonite_chestplate")) {
         stack.func_77966_a(Enchantments.field_180310_c, 4);
         stack.func_77966_a(Enchantments.field_77329_d, 6);
      } else if (this.typeOfArmor.contains("demonite_legging")) {
         stack.func_77966_a(Enchantments.field_180310_c, 4);
         stack.func_77966_a(Enchantments.field_77329_d, 6);
      } else if (this.typeOfArmor.contains("demonite_boots")) {
         stack.func_77966_a(Enchantments.field_180310_c, 4);
         stack.func_77966_a(Enchantments.field_77329_d, 6);
      }

   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
