package fr.diskmth.literia.objects.items;

import com.google.common.collect.Sets;
import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;

public class AxeItem extends ItemTool implements IHasModel {
   private String typeOfAxe = "";
   private static final Set EFFECTIVE_ON;

   public AxeItem(String name, ToolMaterial material) {
      super(material, EFFECTIVE_ON);
      this.setRegistryName(name);
      this.func_77655_b(name);
      this.typeOfAxe = name;
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public float getStrVsBlock(ItemStack stack, IBlockState state) {
      Material material = state.func_185904_a();
      return material != Material.field_151575_d && material != Material.field_151585_k && material != Material.field_151582_l ? 1.0F : this.field_77862_b.func_77998_b();
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfAxe.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER) {
         return true;
      } else if (this.typeOfAxe.contains("tin") && repair.func_77973_b() == ItemsInit.TIN) {
         return true;
      } else if (this.typeOfAxe.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA) {
         return true;
      } else if (this.typeOfAxe.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfAxe.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }

   static {
      EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.field_150344_f, Blocks.field_150342_X, Blocks.field_150364_r, Blocks.field_150363_s, Blocks.field_150486_ae, Blocks.field_150423_aK, Blocks.field_150428_aP, Blocks.field_150440_ba, Blocks.field_150468_ap, Blocks.field_150471_bO, Blocks.field_150452_aw});
   }
}
