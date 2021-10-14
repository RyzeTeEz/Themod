/*    */ package fr.diskmth.literia.init;
/*    */ 
/*    */ import net.minecraft.init.SoundEvents;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraftforge.common.util.EnumHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ToolMaterialsInit
/*    */ {
/*    */   public static Item.ToolMaterial COPPER_TOOLS;
/*    */   public static ItemArmor.ArmorMaterial COPPER_ARMOR;
/*    */   public static Item.ToolMaterial TIN_TOOLS;
/*    */   public static ItemArmor.ArmorMaterial TIN_ARMOR;
/*    */   public static Item.ToolMaterial ISOLUA_TOOLS;
/*    */   public static Item.ToolMaterial ISOLUA_SWORD;
/*    */   public static Item.ToolMaterial ISOLUA_SHOVEL;
/*    */   public static Item.ToolMaterial ISOLUA_HAMMER;
/*    */   public static ItemArmor.ArmorMaterial ISOLUA_ARMOR;
/*    */   public static Item.ToolMaterial LITERIUM_SWORD;
/*    */   public static Item.ToolMaterial LITERIUM_PICKAXE;
/*    */   public static Item.ToolMaterial LITERIUM_AXE;
/*    */   public static Item.ToolMaterial LITERIUM_SHOVEL;
/*    */   public static Item.ToolMaterial LITERIUM_HOE;
/*    */   public static Item.ToolMaterial LITERIUM_HAMMER;
/*    */   public static ItemArmor.ArmorMaterial LITERIUM_ARMOR;
/*    */   public static Item.ToolMaterial DEMONITE_SWORD;
/*    */   public static Item.ToolMaterial DEMONITE_PICKAXE;
/*    */   public static Item.ToolMaterial DEMONITE_AXE;
/*    */   public static Item.ToolMaterial DEMONITE_SHOVEL;
/*    */   public static ItemArmor.ArmorMaterial DEMONITE_ARMOR;
/*    */   
/*    */   public static void registerToolMaterials() {
/* 41 */     new EnumHelper(); COPPER_TOOLS = EnumHelper.addToolMaterial("copper_tools", 2, 250, 6.0F, 1.0F, 14);
/* 42 */     new EnumHelper(); COPPER_ARMOR = EnumHelper.addArmorMaterial("copper_armor", "literiamod:copper", 15, new int[] { 2, 5, 6, 2 }, 14, SoundEvents.field_187725_r, 0.0F);
/*    */     
/* 44 */     new EnumHelper(); TIN_TOOLS = EnumHelper.addToolMaterial("tin_tools", 3, 1561, 8.0F, 3.0F, 10);
/* 45 */     new EnumHelper(); TIN_ARMOR = EnumHelper.addArmorMaterial("tin_armor", "literiamod:tin", 33, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.field_187716_o, 2.0F);
/*    */     
/* 47 */     new EnumHelper(); ISOLUA_TOOLS = EnumHelper.addToolMaterial("isolua_tools", 4, 1951, 10.0F, 1.0F, 11);
/* 48 */     new EnumHelper(); ISOLUA_SWORD = EnumHelper.addToolMaterial("isolua_sword", 4, 1951, 1.0F, 5.0F, 11);
/* 49 */     new EnumHelper(); ISOLUA_SHOVEL = EnumHelper.addToolMaterial("isolua_shovel", 4, 1951, 20.0F, 1.0F, 11);
/* 50 */     new EnumHelper(); ISOLUA_HAMMER = EnumHelper.addToolMaterial("isolua_hammer", 4, 3000, 6.0F, 1.0F, 11);
/* 51 */     new EnumHelper(); ISOLUA_ARMOR = EnumHelper.addArmorMaterial("isolua_armor", "literiamod:isolua", 41, new int[] { 4, 7, 9, 4 }, 11, SoundEvents.field_187716_o, 2.1F);
/*    */     
/* 53 */     new EnumHelper(); LITERIUM_SWORD = EnumHelper.addToolMaterial("literium_sword", 5, 2927, 1.0F, 9.0F, 12);
/* 54 */     new EnumHelper(); LITERIUM_PICKAXE = EnumHelper.addToolMaterial("literium_pickaxe", 5, 2927, 28.0F, 1.0F, 12);
/* 55 */     new EnumHelper(); LITERIUM_AXE = EnumHelper.addToolMaterial("literium_axe", 5, 2927, 14.0F, 1.0F, 12);
/* 56 */     new EnumHelper(); LITERIUM_SHOVEL = EnumHelper.addToolMaterial("literium_shovel", 5, 2927, 20.0F, 1.0F, 12);
/* 57 */     new EnumHelper(); LITERIUM_HOE = EnumHelper.addToolMaterial("literium_hoe", 5, 4000, 1.0F, 1.0F, 12);
/* 58 */     new EnumHelper(); LITERIUM_HAMMER = EnumHelper.addToolMaterial("literium_hammer", 5, 1500, 30.0F, 1.0F, 12);
/* 59 */     new EnumHelper(); LITERIUM_ARMOR = EnumHelper.addArmorMaterial("literium_armor", "literiamod:literium", 62, new int[] { 5, 8, 10, 5 }, 12, SoundEvents.field_187716_o, 2.2F);
/*    */     
/* 61 */     new EnumHelper(); DEMONITE_SWORD = EnumHelper.addToolMaterial("demonite_sword", 5, 2927, 1.0F, 9.0F, 12);
/* 62 */     new EnumHelper(); DEMONITE_PICKAXE = EnumHelper.addToolMaterial("demonite_pickaxe", 5, 2927, 28.0F, 1.0F, 12);
/* 63 */     new EnumHelper(); DEMONITE_AXE = EnumHelper.addToolMaterial("demonite_axe", 5, 2927, 14.0F, 1.0F, 12);
/* 64 */     new EnumHelper(); DEMONITE_SHOVEL = EnumHelper.addToolMaterial("demonite_shovel", 5, 2927, 20.0F, 1.0F, 12);
/* 65 */     new EnumHelper(); DEMONITE_ARMOR = EnumHelper.addArmorMaterial("demonite_armor", "literiamod:demonite", 62, new int[] { 5, 8, 10, 5 }, 12, SoundEvents.field_187716_o, 2.3F);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\init\ToolMaterialsInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */