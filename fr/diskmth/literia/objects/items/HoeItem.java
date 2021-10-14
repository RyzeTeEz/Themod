/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemHoe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class HoeItem extends ItemHoe implements IHasModel {
/* 11 */   private String typeOfHoe = "";
/*    */ 
/*    */   
/*    */   public HoeItem(String name, Item.ToolMaterial material) {
/* 15 */     super(material);
/* 16 */     func_77655_b(name);
/* 17 */     setRegistryName(name);
/* 18 */     this.typeOfHoe = name;
/* 19 */     func_77637_a(null);
/* 20 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/* 25 */     if (this.typeOfHoe.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*    */     {
/* 27 */       return true;
/*    */     }
/*    */     
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 36 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\items\HoeItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */