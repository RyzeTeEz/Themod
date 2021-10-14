package fr.diskmth.literia.objects.creativetabs;

import fr.diskmth.literia.init.BlocksInit;
import fr.diskmth.literia.init.ItemsInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabLiteria1 extends CreativeTabs {
   public CreativeTabLiteria1(String name) {
      super(name);
   }

   @SideOnly(Side.CLIENT)
   public ItemStack func_78016_d() {
      return new ItemStack(ItemsInit.DEMONITE_PICKAXE);
   }

   @SideOnly(Side.CLIENT)
   public boolean hasSearchBar() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void func_78018_a(NonNullList list) {
      super.func_78018_a(list);
      list.add(new ItemStack(ItemsInit.COPPER));
      list.add(new ItemStack(BlocksInit.COPPER_BLOCK));
      list.add(new ItemStack(BlocksInit.COPPER_ORE));
      list.add(new ItemStack(ItemsInit.COPPER_SWORD));
      list.add(new ItemStack(ItemsInit.COPPER_PICKAXE));
      list.add(new ItemStack(ItemsInit.COPPER_AXE));
      list.add(new ItemStack(ItemsInit.COPPER_SHOVEL));
      list.add(new ItemStack(ItemsInit.COPPER_HELMET));
      list.add(new ItemStack(ItemsInit.COPPER_CHESTPLATE));
      list.add(new ItemStack(ItemsInit.COPPER_LEGGING));
      list.add(new ItemStack(ItemsInit.COPPER_BOOTS));
      list.add(new ItemStack(ItemsInit.TIN));
      list.add(new ItemStack(BlocksInit.TIN_BLOCK));
      list.add(new ItemStack(BlocksInit.TIN_ORE));
      list.add(new ItemStack(ItemsInit.TIN_SWORD));
      list.add(new ItemStack(ItemsInit.TIN_PICKAXE));
      list.add(new ItemStack(ItemsInit.TIN_AXE));
      list.add(new ItemStack(ItemsInit.TIN_SHOVEL));
      list.add(new ItemStack(ItemsInit.TIN_HELMET));
      list.add(new ItemStack(ItemsInit.TIN_CHESTPLATE));
      list.add(new ItemStack(ItemsInit.TIN_LEGGING));
      list.add(new ItemStack(ItemsInit.TIN_BOOTS));
      list.add(new ItemStack(ItemsInit.ISOLUA));
      list.add(new ItemStack(BlocksInit.ISOLUA_BLOCK));
      list.add(new ItemStack(BlocksInit.ISOLUA_ORE));
      list.add(new ItemStack(ItemsInit.ISOLUA_SWORD));
      list.add(new ItemStack(ItemsInit.ISOLUA_PICKAXE));
      list.add(new ItemStack(ItemsInit.ISOLUA_AXE));
      list.add(new ItemStack(ItemsInit.ISOLUA_SHOVEL));
      list.add(new ItemStack(ItemsInit.ISOLUA_HAMMER));
      list.add(new ItemStack(BlocksInit.ISOLUA_LADDER));
      list.add(new ItemStack(ItemsInit.ISOLUA_HELMET));
      list.add(new ItemStack(ItemsInit.ISOLUA_CHESTPLATE));
      list.add(new ItemStack(ItemsInit.ISOLUA_LEGGING));
      list.add(new ItemStack(ItemsInit.ISOLUA_BOOTS));
      list.add(new ItemStack(ItemsInit.LITERIUM));
      list.add(new ItemStack(BlocksInit.LITERIUM_BLOCK));
      list.add(new ItemStack(BlocksInit.LITERIUM_ORE));
      list.add(new ItemStack(ItemsInit.LITERIUM_SWORD));
      list.add(new ItemStack(ItemsInit.LITERIUM_PICKAXE));
      list.add(new ItemStack(ItemsInit.LITERIUM_AXE));
      list.add(new ItemStack(ItemsInit.LITERIUM_SHOVEL));
      list.add(new ItemStack(ItemsInit.LITERIUM_HOE));
      list.add(new ItemStack(ItemsInit.LITERIUM_HAMMER));
      list.add(new ItemStack(ItemsInit.LITERIUM_SHEARS));
      list.add(new ItemStack(ItemsInit.LITERIUM_BOW));
      list.add(new ItemStack(ItemsInit.LITERIUM_HELMET));
      list.add(new ItemStack(ItemsInit.LITERIUM_CHESTPLATE));
      list.add(new ItemStack(ItemsInit.LITERIUM_LEGGING));
      list.add(new ItemStack(ItemsInit.LITERIUM_BOOTS));
      list.add(new ItemStack(ItemsInit.LITERIUM_STICK));
      list.add(new ItemStack(ItemsInit.DEMONITE));
      list.add(new ItemStack(BlocksInit.DEMONITE_BLOCK));
      list.add(new ItemStack(BlocksInit.DEMONITE_ORE));
      list.add(new ItemStack(ItemsInit.DEMONITE_SWORD));
      list.add(new ItemStack(ItemsInit.DEMONITE_PICKAXE));
      list.add(new ItemStack(ItemsInit.DEMONITE_AXE));
      list.add(new ItemStack(ItemsInit.DEMONITE_SHOVEL));
      list.add(new ItemStack(ItemsInit.DEMONITE_BOW));
      list.add(new ItemStack(ItemsInit.DEMONITE_HELMET));
      list.add(new ItemStack(ItemsInit.DEMONITE_CHESTPLATE));
      list.add(new ItemStack(ItemsInit.DEMONITE_LEGGING));
      list.add(new ItemStack(ItemsInit.DEMONITE_BOOTS));
      list.add(new ItemStack(ItemsInit.DEMONITE_STICK));
      list.add(new ItemStack(ItemsInit.HEAL_ORB));
      list.add(new ItemStack(ItemsInit.SPEED_ORB));
      list.add(new ItemStack(ItemsInit.STRENGHT_ORB));
      list.add(new ItemStack(ItemsInit.LEGENDARY_ORB));
      list.add(new ItemStack(ItemsInit.HEAL_STICK));
      list.add(new ItemStack(ItemsInit.SPEED_STICK));
      list.add(new ItemStack(ItemsInit.STRENGHT_STICK));
      list.add(new ItemStack(ItemsInit.LEGENDARY_STICK));
      list.add(new ItemStack(BlocksInit.PILLER_TNT));
      list.add(new ItemStack(BlocksInit.CAVE_BLOCK));
      list.add(new ItemStack(ItemsInit.UNCLAIM_FINDER_LVL_1));
      list.add(new ItemStack(ItemsInit.UNCLAIM_FINDER_LVL_2));
      list.add(new ItemStack(ItemsInit.DYNAMITE));
   }
}
