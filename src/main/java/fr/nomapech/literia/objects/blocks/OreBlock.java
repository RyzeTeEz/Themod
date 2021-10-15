package fr.nomapech.literia.objects.blocks;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.BlocksInit;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import java.util.Random;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreBlock extends BlockOre implements IHasModel {
   private boolean multipleDrop = false;
   private boolean isFortuneEnable = false;
   private boolean isExpDropEnable = false;
   private int minDrop;
   private int maxDrop;
   private int minExpDrop;
   private int maxExpDrop;

   public OreBlock(String name, float hardness, float resistance, int harvesLevel, SoundType sound) {
      this.setTranslationKey(name);
      this.setRegistryName(name);
      this.setHardness(hardness);
      this.setResistance(resistance);
      this.setHarvestLevel("pickaxe", harvesLevel);
      this.setSoundType(sound);
      this.setCreativeTab((CreativeTabs)null);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public OreBlock(String name, float hardness, float resistance, int harvesLevel, SoundType sound, int minDrop, int maxDrop, boolean isFortuneEnable, boolean isExpDropEnable, int minExpDrop, int maxExpDrop) {
      this.setTranslationKey(name);
      this.setRegistryName(name);
      this.setHardness(hardness);
      this.setResistance(resistance);
      this.setHarvestLevel("pickaxe", harvesLevel);
      this.setSoundType(sound);
      this.multipleDrop = true;
      this.minDrop = minDrop;
      this.maxDrop = maxDrop;
      this.isFortuneEnable = isFortuneEnable;
      this.isExpDropEnable = isExpDropEnable;
      this.minExpDrop = minExpDrop;
      this.maxExpDrop = maxExpDrop;
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public Item func_180660_a(IBlockState state, Random random, int fortune) {
      return Item.getItemFromBlock(this);
   }

   public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
      if (this.isExpDropEnable) {
         Random rand = world instanceof World ? ((World)world).rand : new Random();
         if (this.func_180660_a(state, rand, fortune) != Item.getItemFromBlock(this)) {
            ;
         }
      }

      return 0;
   }

   public int quantityDropped(int fortune, Random random) {
      if (this.isFortuneEnable) {
         if (fortune > 0) {
            int j = random.nextInt(fortune + 2) - 1;
            if (j < 0) {
               j = 0;
            }

            return this.quantityDropped(random) * (j + 1);
         } else {
            return this.multipleDrop ? this.minDrop + random.nextInt(this.maxDrop - this.minDrop) : 1;
         }
      } else {
         return this.multipleDrop ? this.minDrop + random.nextInt(this.maxDrop - this.minDrop) : 1;
      }
   }

   public ItemStack func_180643_i(IBlockState state) {
      return super.getSilkTouchDrop(state);
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
   }
}
