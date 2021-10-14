/*     */ package fr.diskmth.literia.objects.blocks;
/*     */ 
/*     */ import fr.diskmth.literia.Main;
/*     */ import fr.diskmth.literia.init.BlocksInit;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
/*     */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockTNT;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockStateContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class PillerTNTBlock
/*     */   extends BlockTNT implements IHasModel {
/*  35 */   public static final PropertyBool EXPLODE = PropertyBool.func_177716_a("explode");
/*     */ 
/*     */   
/*     */   public PillerTNTBlock(String name, Material materialIn) {
/*  39 */     func_149663_c(name);
/*  40 */     setRegistryName(name);
/*  41 */     func_149672_a(SoundType.field_185850_c);
/*  42 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)EXPLODE, Boolean.valueOf(false)));
/*  43 */     func_149647_a(null);
/*  44 */     BlocksInit.BLOCKS.add(this);
/*  45 */     ItemsInit.ITEMS.add((new ItemBlock((Block)this)).setRegistryName(name));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {
/*  51 */     super.func_176213_c(worldIn, pos, state);
/*     */     
/*  53 */     if (worldIn.func_175640_z(pos)) {
/*     */       
/*  55 */       func_176206_d(worldIn, pos, state.func_177226_a((IProperty)EXPLODE, Boolean.valueOf(true)));
/*  56 */       worldIn.func_175698_g(pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_189540_a(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
/*  63 */     if (worldIn.func_175640_z(pos)) {
/*     */       
/*  65 */       func_176206_d(worldIn, pos, state.func_177226_a((IProperty)EXPLODE, Boolean.valueOf(true)));
/*  66 */       worldIn.func_175698_g(pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_180652_a(World worldIn, BlockPos pos, Explosion explosionIn) {
/*  73 */     if (!worldIn.field_72995_K) {
/*     */       
/*  75 */       EntityPillerTNTPrimed EntityPillerTNTPrimed = new EntityPillerTNTPrimed(worldIn, (pos.func_177958_n() + 0.5F), pos.func_177956_o(), (pos.func_177952_p() + 0.5F), explosionIn.func_94613_c());
/*  76 */       EntityPillerTNTPrimed.setFuse((short)(worldIn.field_73012_v.nextInt(EntityPillerTNTPrimed.getFuse() / 4) + EntityPillerTNTPrimed.getFuse() / 8));
/*  77 */       worldIn.func_72838_d((Entity)EntityPillerTNTPrimed);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_176206_d(World worldIn, BlockPos pos, IBlockState state) {
/*  84 */     func_180692_a(worldIn, pos, state, (EntityLivingBase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_180692_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
/*  90 */     if (!worldIn.field_72995_K)
/*     */     {
/*  92 */       if (((Boolean)state.func_177229_b((IProperty)EXPLODE)).booleanValue()) {
/*     */         
/*  94 */         EntityPillerTNTPrimed EntityPillerTNTPrimed = new EntityPillerTNTPrimed(worldIn, (pos.func_177958_n() + 0.5F), pos.func_177956_o(), (pos.func_177952_p() + 0.5F), igniter);
/*  95 */         worldIn.func_72838_d((Entity)EntityPillerTNTPrimed);
/*  96 */         worldIn.func_184148_a((EntityPlayer)null, EntityPillerTNTPrimed.field_70165_t, EntityPillerTNTPrimed.field_70163_u, EntityPillerTNTPrimed.field_70161_v, SoundEvents.field_187904_gd, SoundCategory.BLOCKS, 1.0F, 1.0F);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 104 */     ItemStack itemstack = playerIn.func_184586_b(hand);
/*     */     
/* 106 */     if (!itemstack.func_190926_b() && (itemstack.func_77973_b() == Items.field_151033_d || itemstack.func_77973_b() == Items.field_151059_bz)) {
/*     */       
/* 108 */       func_180692_a(worldIn, pos, state.func_177226_a((IProperty)EXPLODE, Boolean.valueOf(true)), (EntityLivingBase)playerIn);
/* 109 */       worldIn.func_180501_a(pos, Blocks.field_150350_a.func_176223_P(), 11);
/*     */       
/* 111 */       if (itemstack.func_77973_b() == Items.field_151033_d) {
/*     */         
/* 113 */         itemstack.func_77972_a(1, (EntityLivingBase)playerIn);
/*     */       }
/* 115 */       else if (!playerIn.field_71075_bZ.field_75098_d) {
/*     */         
/* 117 */         itemstack.func_190918_g(1);
/*     */       } 
/*     */       
/* 120 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 124 */     return super.func_180639_a(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_180634_a(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
/* 131 */     if (!worldIn.field_72995_K && entityIn instanceof EntityArrow) {
/*     */       
/* 133 */       EntityArrow entityarrow = (EntityArrow)entityIn;
/*     */       
/* 135 */       if (entityarrow.func_70027_ad()) {
/*     */         
/* 137 */         func_180692_a(worldIn, pos, worldIn.func_180495_p(pos).func_177226_a((IProperty)EXPLODE, Boolean.valueOf(true)), (entityarrow.field_70250_c instanceof EntityLivingBase) ? (EntityLivingBase)entityarrow.field_70250_c : null);
/* 138 */         worldIn.func_175698_g(pos);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion explosionIn) {
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 152 */     return func_176223_P().func_177226_a((IProperty)EXPLODE, Boolean.valueOf(((meta & 0x1) > 0)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 158 */     return ((Boolean)state.func_177229_b((IProperty)EXPLODE)).booleanValue() ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockStateContainer func_180661_e() {
/* 164 */     return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)EXPLODE });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerModels() {
/* 170 */     Main.proxy.registerItemRenderer(Item.func_150898_a((Block)this), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\blocks\PillerTNTBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */