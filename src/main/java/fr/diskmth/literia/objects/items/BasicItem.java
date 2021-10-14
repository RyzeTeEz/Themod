/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class BasicItem
/*    */   extends Item
/*    */   implements IHasModel {
/*    */   public BasicItem(String name) {
/* 12 */     func_77655_b(name);
/* 13 */     setRegistryName(name);
/* 14 */     func_77637_a(null);
/* 15 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 21 */     Main.proxy.registerItemRenderer(this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\items\BasicItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */