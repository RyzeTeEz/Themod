package fr.nomapech.literia.objects.blocks;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.BlocksInit;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CaveBlock extends Block implements IHasModel {
   public CaveBlock(String name, Material material, float hardness, float resistance, SoundType sound) {
      super(material);
      this.setTranslationKey(name);
      this.setRegistryName(name);
      this.setHardness(hardness);
      this.setResistance(resistance);
      this.setSoundType(sound);
      this.setCreativeTab((CreativeTabs)null);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   @SideOnly(Side.CLIENT)
   public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT_MIPPED;
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
   }
}
