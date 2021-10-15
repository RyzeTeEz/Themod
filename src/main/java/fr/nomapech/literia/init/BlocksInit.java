package fr.nomapech.literia.init;

import fr.nomapech.literia.objects.blocks.BasicBlock;
import fr.nomapech.literia.objects.blocks.CaveBlock;
import fr.nomapech.literia.objects.blocks.LadderBlock;
import fr.nomapech.literia.objects.blocks.OreBlock;
import fr.nomapech.literia.objects.blocks.PillerTNTBlock;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlocksInit {
   public static List BLOCKS = new ArrayList();
   public static Block COPPER_BLOCK;
   public static Block COPPER_ORE;
   public static Block TIN_BLOCK;
   public static Block TIN_ORE;
   public static Block ISOLUA_BLOCK;
   public static Block ISOLUA_ORE;
   public static Block LITERIUM_BLOCK;
   public static Block LITERIUM_ORE;
   public static Block DEMONITE_BLOCK;
   public static Block DEMONITE_ORE;
   public static Block PILLER_TNT;
   public static Block CAVE_BLOCK;
   public static Block ISOLUA_LADDER;

   static {
      COPPER_BLOCK = new BasicBlock("copper_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
      COPPER_ORE = new OreBlock("copper_ore", 3.0F, 5.0F, 3, SoundType.STONE);
      TIN_BLOCK = new BasicBlock("tin_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
      TIN_ORE = new OreBlock("tin_ore", 3.0F, 5.0F, 3, SoundType.STONE);
      ISOLUA_BLOCK = new BasicBlock("isolua_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
      ISOLUA_ORE = new OreBlock("isolua_ore", 3.0F, 5.0F, 3, SoundType.STONE);
      LITERIUM_BLOCK = new BasicBlock("literium_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
      LITERIUM_ORE = new OreBlock("literium_ore", 3.0F, 5.0F, 3, SoundType.STONE);
      DEMONITE_BLOCK = new BasicBlock("demonite_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
      DEMONITE_ORE = new OreBlock("demonite_ore", 3.0F, 5.0F, 3, SoundType.STONE, 1, 2, false, true, 20, 30);
      PILLER_TNT = new PillerTNTBlock("piller_tnt", Material.TNT);
      CAVE_BLOCK = new CaveBlock("cave_block", Material.GLASS, 0.3F, 0.3F, SoundType.GLASS);
      ISOLUA_LADDER = new LadderBlock("isolua_ladders");
   }
}
