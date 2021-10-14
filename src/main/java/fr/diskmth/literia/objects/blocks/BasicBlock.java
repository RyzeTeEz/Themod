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
/*    */ 
/*    */ public class BasicBlock
/*    */   extends Block
/*    */   implements IHasModel {
/*    */   public BasicBlock(String name, Material material, float hardness, float resistance, SoundType sound) {
/* 17 */     super(material);
/* 18 */     func_149663_c(name);
/* 19 */     setRegistryName(name);
/* 20 */     func_149711_c(hardness);
/* 21 */     func_149752_b(resistance);
/* 22 */     func_149672_a(sound);
/* 23 */     func_149647_a(null);
/* 24 */     BlocksInit.BLOCKS.add(this);
/* 25 */     ItemsInit.ITEMS.add((new ItemBlock(this)).setRegistryName(name));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 31 */     Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\blocks\BasicBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */