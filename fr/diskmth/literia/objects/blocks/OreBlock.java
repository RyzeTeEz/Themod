/*     */ package fr.diskmth.literia.objects.blocks;
/*     */ 
/*     */ import fr.diskmth.literia.Main;
/*     */ import fr.diskmth.literia.init.BlocksInit;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockOre;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class OreBlock
/*     */   extends BlockOre
/*     */   implements IHasModel
/*     */ {
/*     */   private boolean multipleDrop = false;
/*     */   private boolean isFortuneEnable = false;
/*     */   private boolean isExpDropEnable = false;
/*     */   private int minDrop;
/*     */   private int maxDrop;
/*     */   private int minExpDrop;
/*     */   private int maxExpDrop;
/*     */   
/*     */   public OreBlock(String name, float hardness, float resistance, int harvesLevel, SoundType sound) {
/*  33 */     func_149663_c(name);
/*  34 */     setRegistryName(name);
/*  35 */     func_149711_c(hardness);
/*  36 */     func_149752_b(resistance);
/*  37 */     setHarvestLevel("pickaxe", harvesLevel);
/*  38 */     func_149672_a(sound);
/*  39 */     func_149647_a(null);
/*  40 */     BlocksInit.BLOCKS.add(this);
/*  41 */     ItemsInit.ITEMS.add((new ItemBlock((Block)this)).setRegistryName(name));
/*     */   }
/*     */ 
/*     */   
/*     */   public OreBlock(String name, float hardness, float resistance, int harvesLevel, SoundType sound, int minDrop, int maxDrop, boolean isFortuneEnable, boolean isExpDropEnable, int minExpDrop, int maxExpDrop) {
/*  46 */     func_149663_c(name);
/*  47 */     setRegistryName(name);
/*  48 */     func_149711_c(hardness);
/*  49 */     func_149752_b(resistance);
/*  50 */     setHarvestLevel("pickaxe", harvesLevel);
/*  51 */     func_149672_a(sound);
/*  52 */     this.multipleDrop = true;
/*  53 */     this.minDrop = minDrop;
/*  54 */     this.maxDrop = maxDrop;
/*  55 */     this.isFortuneEnable = isFortuneEnable;
/*  56 */     this.isExpDropEnable = isExpDropEnable;
/*  57 */     this.minExpDrop = minExpDrop;
/*  58 */     this.maxExpDrop = maxExpDrop;
/*  59 */     BlocksInit.BLOCKS.add(this);
/*  60 */     ItemsInit.ITEMS.add((new ItemBlock((Block)this)).setRegistryName(name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_180660_a(IBlockState state, Random random, int fortune) {
/*  73 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
/*  81 */     if (this.isExpDropEnable) {
/*     */       
/*  83 */       Random rand = (world instanceof World) ? ((World)world).field_73012_v : new Random();
/*     */       
/*  85 */       if (func_180660_a(state, rand, fortune) != Item.func_150898_a((Block)this));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int quantityDropped(int fortune, Random random) {
/*  99 */     if (this.isFortuneEnable == true) {
/*     */       
/* 101 */       if (fortune > 0) {
/*     */         
/* 103 */         int j = random.nextInt(fortune + 2) - 1;
/*     */         
/* 105 */         if (j < 0)
/*     */         {
/* 107 */           j = 0;
/*     */         }
/* 109 */         return func_149745_a(random) * (j + 1);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 114 */       return this.multipleDrop ? (this.minDrop + random.nextInt(this.maxDrop - this.minDrop)) : 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     return this.multipleDrop ? (this.minDrop + random.nextInt(this.maxDrop - this.minDrop)) : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_180643_i(IBlockState state) {
/* 127 */     return super.func_180643_i(state);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerModels() {
/* 133 */     Main.proxy.registerItemRenderer(Item.func_150898_a((Block)this), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\blocks\OreBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */