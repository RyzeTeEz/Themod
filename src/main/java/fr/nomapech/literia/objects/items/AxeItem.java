package fr.nomapech.literia.objects.items;

import com.google.common.collect.Sets;
import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class AxeItem extends ItemTool implements IHasModel {
   private String typeOfAxe = "";
   private static final Set EFFECTIVE_ON;

   public AxeItem(String name, ToolMaterial material) {
      super(material, EFFECTIVE_ON);
      this.setRegistryName(name);
      this.setTranslationKey(name);
      this.typeOfAxe = name;
      this.setCreativeTab((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public float getStrVsBlock(ItemStack stack, IBlockState state) {
      Material material = state.getMaterial();
      return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 1.0F : this.toolMaterial.getEfficiency();
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfAxe.contains("copper") && repair.getItem() == ItemsInit.COPPER) {
         return true;
      } else if (this.typeOfAxe.contains("tin") && repair.getItem() == ItemsInit.TIN) {
         return true;
      } else if (this.typeOfAxe.contains("isolua") && repair.getItem() == ItemsInit.ISOLUA) {
         return true;
      } else if (this.typeOfAxe.contains("literium") && repair.getItem() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfAxe.contains("demonite") && repair.getItem() == ItemsInit.DEMONITE;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }

   static {
      EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
   }
}
