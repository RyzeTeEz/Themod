package fr.diskmth.literia.init;

import fr.diskmth.literia.objects.blocks.BasicBlock;
import fr.diskmth.literia.objects.blocks.CaveBlock;
import fr.diskmth.literia.objects.blocks.LadderBlock;
import fr.diskmth.literia.objects.blocks.OreBlock;
import fr.diskmth.literia.objects.blocks.PillerTNTBlock;
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
      COPPER_BLOCK = new BasicBlock("copper_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
      COPPER_ORE = new OreBlock("copper_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
      TIN_BLOCK = new BasicBlock("tin_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
      TIN_ORE = new OreBlock("tin_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
      ISOLUA_BLOCK = new BasicBlock("isolua_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
      ISOLUA_ORE = new OreBlock("isolua_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
      LITERIUM_BLOCK = new BasicBlock("literium_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
      LITERIUM_ORE = new OreBlock("literium_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
      DEMONITE_BLOCK = new BasicBlock("demonite_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
      DEMONITE_ORE = new OreBlock("demonite_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d, 1, 2, false, true, 20, 30);
      PILLER_TNT = new PillerTNTBlock("piller_tnt", Material.field_151590_u);
      CAVE_BLOCK = new CaveBlock("cave_block", Material.field_151592_s, 0.3F, 0.3F, SoundType.field_185853_f);
      ISOLUA_LADDER = new LadderBlock("isolua_ladders");
   }
}
