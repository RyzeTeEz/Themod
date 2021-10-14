/*    */ package fr.diskmth.literia.world;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.IChunkGenerator;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenOres
/*    */   implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/* 22 */     world.field_73011_w.getDimension();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, double chance, int minHeight, int maxHeight) {
/* 31 */     if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
/*    */     
/* 33 */     int heightDiff = maxHeight - minHeight + 1;
/*    */     
/* 35 */     for (int i = 0; i < chance; i++) {
/*    */       
/* 37 */       int x = chunkX * 16 + rand.nextInt(16);
/* 38 */       int y = minHeight + rand.nextInt(heightDiff);
/* 39 */       int z = chunkZ * 16 + rand.nextInt(16);
/*    */       
/* 41 */       gen.func_180709_b(world, rand, new BlockPos(x, y, z));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\world\WorldGenOres.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */