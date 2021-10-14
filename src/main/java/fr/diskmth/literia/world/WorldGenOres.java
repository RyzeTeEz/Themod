package fr.diskmth.literia.world;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator {
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
      world.field_73011_w.getDimension();
   }

   private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, double chance, int minHeight, int maxHeight) {
      if (minHeight <= maxHeight && minHeight >= 0 && maxHeight <= 256) {
         int heightDiff = maxHeight - minHeight + 1;

         for(int i = 0; (double)i < chance; ++i) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);
            gen.func_180709_b(world, rand, new BlockPos(x, y, z));
         }

      } else {
         throw new IllegalArgumentException("Ore generated out of bounds");
      }
   }
}
