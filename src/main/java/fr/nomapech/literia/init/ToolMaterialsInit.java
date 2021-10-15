package fr.nomapech.literia.init;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialsInit {
   public static ToolMaterial COPPER_TOOLS;
   public static ArmorMaterial COPPER_ARMOR;
   public static ToolMaterial TIN_TOOLS;
   public static ArmorMaterial TIN_ARMOR;
   public static ToolMaterial ISOLUA_TOOLS;
   public static ToolMaterial ISOLUA_SWORD;
   public static ToolMaterial ISOLUA_SHOVEL;
   public static ToolMaterial ISOLUA_HAMMER;
   public static ArmorMaterial ISOLUA_ARMOR;
   public static ToolMaterial LITERIUM_SWORD;
   public static ToolMaterial LITERIUM_PICKAXE;
   public static ToolMaterial LITERIUM_AXE;
   public static ToolMaterial LITERIUM_SHOVEL;
   public static ToolMaterial LITERIUM_HOE;
   public static ToolMaterial LITERIUM_HAMMER;
   public static ArmorMaterial LITERIUM_ARMOR;
   public static ToolMaterial DEMONITE_SWORD;
   public static ToolMaterial DEMONITE_PICKAXE;
   public static ToolMaterial DEMONITE_AXE;
   public static ToolMaterial DEMONITE_SHOVEL;
   public static ArmorMaterial DEMONITE_ARMOR;

   public static void registerToolMaterials() {
      new EnumHelper();
      COPPER_TOOLS = EnumHelper.addToolMaterial("copper_tools", 2, 250, 6.0F, 1.0F, 14);
      new EnumHelper();
      COPPER_ARMOR = EnumHelper.addArmorMaterial("copper_armor", "literiamod:copper", 15, new int[]{2, 5, 6, 2}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
      new EnumHelper();
      TIN_TOOLS = EnumHelper.addToolMaterial("tin_tools", 3, 1561, 8.0F, 3.0F, 10);
      new EnumHelper();
      TIN_ARMOR = EnumHelper.addArmorMaterial("tin_armor", "literiamod:tin", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
      new EnumHelper();
      ISOLUA_TOOLS = EnumHelper.addToolMaterial("isolua_tools", 4, 1951, 10.0F, 1.0F, 11);
      new EnumHelper();
      ISOLUA_SWORD = EnumHelper.addToolMaterial("isolua_sword", 4, 1951, 1.0F, 5.0F, 11);
      new EnumHelper();
      ISOLUA_SHOVEL = EnumHelper.addToolMaterial("isolua_shovel", 4, 1951, 20.0F, 1.0F, 11);
      new EnumHelper();
      ISOLUA_HAMMER = EnumHelper.addToolMaterial("isolua_hammer", 4, 3000, 6.0F, 1.0F, 11);
      new EnumHelper();
      ISOLUA_ARMOR = EnumHelper.addArmorMaterial("isolua_armor", "literiamod:isolua", 41, new int[]{4, 7, 9, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.1F);
      new EnumHelper();
      LITERIUM_SWORD = EnumHelper.addToolMaterial("literium_sword", 5, 2927, 1.0F, 9.0F, 12);
      new EnumHelper();
      LITERIUM_PICKAXE = EnumHelper.addToolMaterial("literium_pickaxe", 5, 2927, 28.0F, 1.0F, 12);
      new EnumHelper();
      LITERIUM_AXE = EnumHelper.addToolMaterial("literium_axe", 5, 2927, 14.0F, 1.0F, 12);
      new EnumHelper();
      LITERIUM_SHOVEL = EnumHelper.addToolMaterial("literium_shovel", 5, 2927, 20.0F, 1.0F, 12);
      new EnumHelper();
      LITERIUM_HOE = EnumHelper.addToolMaterial("literium_hoe", 5, 4000, 1.0F, 1.0F, 12);
      new EnumHelper();
      LITERIUM_HAMMER = EnumHelper.addToolMaterial("literium_hammer", 5, 1500, 30.0F, 1.0F, 12);
      new EnumHelper();
      LITERIUM_ARMOR = EnumHelper.addArmorMaterial("literium_armor", "literiamod:literium", 62, new int[]{5, 8, 10, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.2F);
      new EnumHelper();
      DEMONITE_SWORD = EnumHelper.addToolMaterial("demonite_sword", 5, 2927, 1.0F, 9.0F, 12);
      new EnumHelper();
      DEMONITE_PICKAXE = EnumHelper.addToolMaterial("demonite_pickaxe", 5, 2927, 28.0F, 1.0F, 12);
      new EnumHelper();
      DEMONITE_AXE = EnumHelper.addToolMaterial("demonite_axe", 5, 2927, 14.0F, 1.0F, 12);
      new EnumHelper();
      DEMONITE_SHOVEL = EnumHelper.addToolMaterial("demonite_shovel", 5, 2927, 20.0F, 1.0F, 12);
      new EnumHelper();
      DEMONITE_ARMOR = EnumHelper.addArmorMaterial("demonite_armor", "literiamod:demonite", 62, new int[]{5, 8, 10, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.3F);
   }
}
