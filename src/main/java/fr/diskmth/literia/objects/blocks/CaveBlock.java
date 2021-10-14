/*    */ package fr.diskmth.literia.objects.blocks;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.BlocksInit;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.SoundType;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.BlockRenderLayer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class CaveBlock
/*    */   extends Block
/*    */   implements IHasModel {
/*    */   public CaveBlock(String name, Material material, float hardness, float resistance, SoundType sound) {
/* 20 */     super(material);
/* 21 */     func_149663_c(name);
/* 22 */     setRegistryName(name);
/* 23 */     func_149711_c(hardness);
/* 24 */     func_149752_b(resistance);
/* 25 */     func_149672_a(sound);
/* 26 */     func_149647_a(null);
/* 27 */     BlocksInit.BLOCKS.add(this);
/* 28 */     ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public BlockRenderLayer func_180664_k() {
/* 34 */     return BlockRenderLayer.CUTOUT_MIPPED;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 40 */     Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\blocks\CaveBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */