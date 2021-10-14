package fr.diskmth.literia.objects.blocks;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.BlocksInit;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class PillerTNTBlock extends BlockTNT implements IHasModel {
   public static final PropertyBool EXPLODE = PropertyBool.func_177716_a("explode");

   public PillerTNTBlock(String name, Material materialIn) {
      this.func_149663_c(name);
      this.setRegistryName(name);
      this.func_149672_a(SoundType.field_185850_c);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(EXPLODE, false));
      this.func_149647_a((CreativeTabs)null);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {
      super.func_176213_c(worldIn, pos, state);
      if (worldIn.func_175640_z(pos)) {
         this.func_176206_d(worldIn, pos, state.func_177226_a(EXPLODE, true));
         worldIn.func_175698_g(pos);
      }

   }

   public void func_189540_a(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
      if (worldIn.func_175640_z(pos)) {
         this.func_176206_d(worldIn, pos, state.func_177226_a(EXPLODE, true));
         worldIn.func_175698_g(pos);
      }

   }

   public void func_180652_a(World worldIn, BlockPos pos, Explosion explosionIn) {
      if (!worldIn.field_72995_K) {
         EntityPillerTNTPrimed EntityPillerTNTPrimed = new EntityPillerTNTPrimed(worldIn, (double)((float)pos.func_177958_n() + 0.5F), (double)pos.func_177956_o(), (double)((float)pos.func_177952_p() + 0.5F), explosionIn.func_94613_c());
         EntityPillerTNTPrimed.setFuse((short)(worldIn.field_73012_v.nextInt(EntityPillerTNTPrimed.getFuse() / 4) + EntityPillerTNTPrimed.getFuse() / 8));
         worldIn.func_72838_d(EntityPillerTNTPrimed);
      }

   }

   public void func_176206_d(World worldIn, BlockPos pos, IBlockState state) {
      this.func_180692_a(worldIn, pos, state, (EntityLivingBase)null);
   }

   public void func_180692_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
      if (!worldIn.field_72995_K && ((Boolean)state.func_177229_b(EXPLODE)).booleanValue()) {
         EntityPillerTNTPrimed EntityPillerTNTPrimed = new EntityPillerTNTPrimed(worldIn, (double)((float)pos.func_177958_n() + 0.5F), (double)pos.func_177956_o(), (double)((float)pos.func_177952_p() + 0.5F), igniter);
         worldIn.func_72838_d(EntityPillerTNTPrimed);
         worldIn.func_184148_a((EntityPlayer)null, EntityPillerTNTPrimed.field_70165_t, EntityPillerTNTPrimed.field_70163_u, EntityPillerTNTPrimed.field_70161_v, SoundEvents.field_187904_gd, SoundCategory.BLOCKS, 1.0F, 1.0F);
      }

   }

   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
      ItemStack itemstack = playerIn.func_184586_b(hand);
      if (!itemstack.func_190926_b() && (itemstack.func_77973_b() == Items.field_151033_d || itemstack.func_77973_b() == Items.field_151059_bz)) {
         this.func_180692_a(worldIn, pos, state.func_177226_a(EXPLODE, true), playerIn);
         worldIn.func_180501_a(pos, Blocks.field_150350_a.func_176223_P(), 11);
         if (itemstack.func_77973_b() == Items.field_151033_d) {
            itemstack.func_77972_a(1, playerIn);
         } else if (!playerIn.field_71075_bZ.field_75098_d) {
            itemstack.func_190918_g(1);
         }

         return true;
      } else {
         return super.func_180639_a(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
      }
   }

   public void func_180634_a(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
      if (!worldIn.field_72995_K && entityIn instanceof EntityArrow) {
         EntityArrow entityarrow = (EntityArrow)entityIn;
         if (entityarrow.func_70027_ad()) {
            this.func_180692_a(worldIn, pos, worldIn.func_180495_p(pos).func_177226_a(EXPLODE, true), entityarrow.field_70250_c instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.field_70250_c : null);
            worldIn.func_175698_g(pos);
         }
      }

   }

   public boolean func_149659_a(Explosion explosionIn) {
      return false;
   }

   public IBlockState func_176203_a(int meta) {
      return this.func_176223_P().func_177226_a(EXPLODE, (meta & 1) > 0);
   }

   public int func_176201_c(IBlockState state) {
      return ((Boolean)state.func_177229_b(EXPLODE)).booleanValue() ? 1 : 0;
   }

   protected BlockStateContainer func_180661_e() {
      return new BlockStateContainer(this, new IProperty[]{EXPLODE});
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0);
   }
}
