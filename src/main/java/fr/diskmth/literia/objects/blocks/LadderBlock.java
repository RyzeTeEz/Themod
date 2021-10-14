package fr.diskmth.literia.objects.blocks;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.BlocksInit;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;

public class LadderBlock extends BlockLadder implements IHasModel {
   public LadderBlock(String name) {
      this.func_149663_c(name);
      this.setRegistryName(name);
      this.func_149647_a((CreativeTabs)null);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176382_a, EnumFacing.NORTH));
      this.func_149672_a(SoundType.field_185857_j);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0);
   }
}
