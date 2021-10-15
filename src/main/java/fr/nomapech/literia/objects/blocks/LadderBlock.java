package fr.nomapech.literia.objects.blocks;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.BlocksInit;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;

public class LadderBlock extends BlockLadder implements IHasModel {
   public LadderBlock(String name) {
      this.setTranslationKey(name);
      this.setRegistryName(name);
      this.setCreativeTab((CreativeTabs)null);
      this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
      this.setSoundType(SoundType.LADDER);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
   }
}
