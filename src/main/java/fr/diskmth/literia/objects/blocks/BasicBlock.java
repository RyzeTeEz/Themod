package fr.diskmth.literia.objects.blocks;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.BlocksInit;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BasicBlock extends Block implements IHasModel {
   public BasicBlock(String name, Material material, float hardness, float resistance, SoundType sound) {
      super(material);
      this.func_149663_c(name);
      this.setRegistryName(name);
      this.func_149711_c(hardness);
      this.func_149752_b(resistance);
      this.func_149672_a(sound);
      this.func_149647_a((CreativeTabs)null);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0);
   }
}
