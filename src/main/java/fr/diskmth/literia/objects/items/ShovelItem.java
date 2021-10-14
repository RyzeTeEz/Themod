/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemSpade;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ShovelItem extends ItemSpade implements IHasModel {
/* 11 */   private String typeOfShovel = "";
/*    */ 
/*    */   
/*    */   public ShovelItem(String name, Item.ToolMaterial material) {
/* 15 */     super(material);
/* 16 */     setRegistryName(name);
/* 17 */     func_77655_b(name);
/* 18 */     this.typeOfShovel = name;
/* 19 */     func_77637_a(null);
/* 20 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/* 25 */     if (this.typeOfShovel.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER)
/*    */     {
/* 27 */       return true;
/*    */     }
/*    */     
/* 30 */     if (this.typeOfShovel.contains("tin") && repair.func_77973_b() == ItemsInit.TIN)
/*    */     {
/* 32 */       return true;
/*    */     }
/*    */     
/* 35 */     if (this.typeOfShovel.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA)
/*    */     {
/* 37 */       return true;
/*    */     }
/*    */     
/* 40 */     if (this.typeOfShovel.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*    */     {
/* 42 */       return true;
/*    */     }
/*    */     
/* 45 */     if (this.typeOfShovel.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE)
/*    */     {
/* 47 */       return true;
/*    */     }
/*    */     
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 56 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\items\ShovelItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */