/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemTool;
/*    */ 
/*    */ public class AxeItem
/*    */   extends ItemTool
/*    */   implements IHasModel {
/* 19 */   private String typeOfAxe = "";
/*    */   
/* 21 */   private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet((Object[])new Block[] { Blocks.field_150344_f, Blocks.field_150342_X, Blocks.field_150364_r, Blocks.field_150363_s, (Block)Blocks.field_150486_ae, Blocks.field_150423_aK, Blocks.field_150428_aP, Blocks.field_150440_ba, Blocks.field_150468_ap, Blocks.field_150471_bO, Blocks.field_150452_aw });
/*    */ 
/*    */   
/*    */   public AxeItem(String name, Item.ToolMaterial material) {
/* 25 */     super(material, EFFECTIVE_ON);
/* 26 */     setRegistryName(name);
/* 27 */     func_77655_b(name);
/* 28 */     this.typeOfAxe = name;
/* 29 */     func_77637_a(null);
/* 30 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public float getStrVsBlock(ItemStack stack, IBlockState state) {
/* 35 */     Material material = state.func_185904_a();
/* 36 */     return (material != Material.field_151575_d && material != Material.field_151585_k && material != Material.field_151582_l) ? 1.0F : this.field_77862_b.func_77998_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/* 41 */     if (this.typeOfAxe.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER)
/*    */     {
/* 43 */       return true;
/*    */     }
/*    */     
/* 46 */     if (this.typeOfAxe.contains("tin") && repair.func_77973_b() == ItemsInit.TIN)
/*    */     {
/* 48 */       return true;
/*    */     }
/*    */     
/* 51 */     if (this.typeOfAxe.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA)
/*    */     {
/* 53 */       return true;
/*    */     }
/*    */     
/* 56 */     if (this.typeOfAxe.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*    */     {
/* 58 */       return true;
/*    */     }
/*    */     
/* 61 */     if (this.typeOfAxe.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE)
/*    */     {
/* 63 */       return true;
/*    */     }
/*    */     
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 72 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\items\AxeItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */