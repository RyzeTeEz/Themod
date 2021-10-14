/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemShears;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ShearsItem extends ItemShears implements IHasModel {
/* 11 */   private String typeOfshears = "";
/*    */ 
/*    */   
/*    */   public ShearsItem(String name, int maxDamage) {
/* 15 */     func_77655_b(name);
/* 16 */     setRegistryName(name);
/* 17 */     func_77625_d(1);
/* 18 */     func_77656_e(maxDamage);
/* 19 */     func_77637_a(null);
/* 20 */     this.typeOfshears = name;
/* 21 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/* 27 */     if (this.typeOfshears.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*    */     {
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 37 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\items\ShearsItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */