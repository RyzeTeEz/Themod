package fr.nomapech.literia.objects.blocks;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.BlocksInit;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.objects.entity.EntityPillerTNTPrimed;
import fr.nomapech.literia.utils.interfaces.IHasModel;
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
   public static final PropertyBool EXPLODE = PropertyBool.create("explode");

   public PillerTNTBlock(String name, Material materialIn) {
      this.setTranslationKey(name);
      this.setRegistryName(name);
      this.setSoundType(SoundType.PLANT);
      this.setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, false));
      this.setCreativeTab((CreativeTabs)null);
      BlocksInit.BLOCKS.add(this);
      ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
   }

   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
      super.onBlockAdded(worldIn, pos, state);
      if (worldIn.isBlockPowered(pos)) {
         this.func_176206_d(worldIn, pos, state.withProperty(EXPLODE, true));
         worldIn.setBlockToAir(pos);
      }

   }

   public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
      if (worldIn.isBlockPowered(pos)) {
         this.onPlayerDestroy(worldIn, pos, state.withProperty(EXPLODE, true));
         worldIn.setBlockToAir(pos);
      }

   }

   public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
      if (!worldIn.isRemote) {
         EntityPillerTNTPrimed EntityPillerTNTPrimed = new EntityPillerTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
         EntityPillerTNTPrimed.setFuse((short)(worldIn.rand.nextInt(EntityPillerTNTPrimed.getFuse() / 4) + EntityPillerTNTPrimed.getFuse() / 8));
         worldIn.spawnEntity(EntityPillerTNTPrimed);
      }

   }

   public void func_176206_d(World worldIn, BlockPos pos, IBlockState state) {
      this.func_180692_a(worldIn, pos, state, (EntityLivingBase)null);
   }

   public void func_180692_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
      if (!worldIn.isRemote && ((Boolean)state.getValue(EXPLODE)).booleanValue()) {
         EntityPillerTNTPrimed EntityPillerTNTPrimed = new EntityPillerTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), igniter);
         worldIn.spawnEntity(EntityPillerTNTPrimed);
         worldIn.playSound((EntityPlayer)null, EntityPillerTNTPrimed.posX, EntityPillerTNTPrimed.posY, EntityPillerTNTPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
      }

   }

   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
      ItemStack itemstack = playerIn.getHeldItem(hand);
      if (!itemstack.isEmpty() && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
         this.func_180692_a(worldIn, pos, state.withProperty(EXPLODE, true), playerIn);
         worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
         if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
            itemstack.damageItem(1, playerIn);
         } else if (!playerIn.capabilities.isCreativeMode) {
            itemstack.shrink(1);
         }

         return true;
      } else {
         return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
      }
   }

   public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
      if (!worldIn.isRemote && entityIn instanceof EntityArrow) {
         EntityArrow entityarrow = (EntityArrow)entityIn;
         if (entityarrow.isBurning()) {
            this.explode(worldIn, pos, worldIn.getBlockState(pos).withProperty(EXPLODE, true), entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
            worldIn.setBlockToAir(pos);
         }
      }

   }

   public boolean func_149659_a(Explosion explosionIn) {
      return false;
   }

   public IBlockState func_176203_a(int meta) {
      return this.getDefaultState().withProperty(EXPLODE, (meta & 1) > 0);
   }

   public int func_176201_c(IBlockState state) {
      return ((Boolean)state.getValue(EXPLODE)).booleanValue() ? 1 : 0;
   }

   protected BlockStateContainer func_180661_e() {
      return new BlockStateContainer(this, new IProperty[]{EXPLODE});
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
   }
}
