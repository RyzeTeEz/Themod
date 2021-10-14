/*    */ package fr.diskmth.literia.init;
/*    */ import fr.diskmth.literia.objects.blocks.BasicBlock;
/*    */ import fr.diskmth.literia.objects.blocks.CaveBlock;
/*    */ import fr.diskmth.literia.objects.blocks.LadderBlock;
/*    */ import fr.diskmth.literia.objects.blocks.OreBlock;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.SoundType;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ public class BlocksInit {
/* 13 */   public static List<Block> BLOCKS = new ArrayList<>();
/*    */ 
/*    */   
/* 16 */   public static Block COPPER_BLOCK = (Block)new BasicBlock("copper_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
/* 17 */   public static Block COPPER_ORE = (Block)new OreBlock("copper_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
/*    */   
/* 19 */   public static Block TIN_BLOCK = (Block)new BasicBlock("tin_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
/* 20 */   public static Block TIN_ORE = (Block)new OreBlock("tin_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
/*    */   
/* 22 */   public static Block ISOLUA_BLOCK = (Block)new BasicBlock("isolua_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
/* 23 */   public static Block ISOLUA_ORE = (Block)new OreBlock("isolua_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
/*    */   
/* 25 */   public static Block LITERIUM_BLOCK = (Block)new BasicBlock("literium_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
/* 26 */   public static Block LITERIUM_ORE = (Block)new OreBlock("literium_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d);
/*    */   
/* 28 */   public static Block DEMONITE_BLOCK = (Block)new BasicBlock("demonite_block", Material.field_151573_f, 5.0F, 10.0F, SoundType.field_185852_e);
/* 29 */   public static Block DEMONITE_ORE = (Block)new OreBlock("demonite_ore", 3.0F, 5.0F, 3, SoundType.field_185851_d, 1, 2, false, true, 20, 30);
/*    */   
/* 31 */   public static Block PILLER_TNT = (Block)new PillerTNTBlock("piller_tnt", Material.field_151590_u);
/* 32 */   public static Block CAVE_BLOCK = (Block)new CaveBlock("cave_block", Material.field_151592_s, 0.3F, 0.3F, SoundType.field_185853_f);
/* 33 */   public static Block ISOLUA_LADDER = (Block)new LadderBlock("isolua_ladders");
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\init\BlocksInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */