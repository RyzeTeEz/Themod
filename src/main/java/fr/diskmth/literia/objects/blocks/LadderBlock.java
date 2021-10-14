/*    */ package fr.diskmth.literia.objects.blocks;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.BlocksInit;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockLadder;
/*    */ import net.minecraft.block.SoundType;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ 
/*    */ public class LadderBlock extends BlockLadder implements IHasModel {
/*    */   public LadderBlock(String name) {
/* 17 */     func_149663_c(name);
/* 18 */     setRegistryName(name);
/* 19 */     func_149647_a(null);
/* 20 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)field_176382_a, (Comparable)EnumFacing.NORTH));
/* 21 */     func_149672_a(SoundType.field_185857_j);
/* 22 */     BlocksInit.BLOCKS.add(this);
/* 23 */     ItemsInit.ITEMS.add((new ItemBlock((Block)this)).setRegistryName(name));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 29 */     Main.proxy.registerItemRenderer(Item.func_150898_a((Block)this), 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\blocks\LadderBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */