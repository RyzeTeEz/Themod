/*    */ package fr.diskmth.literia.init;
/*    */ import fr.diskmth.literia.objects.items.ArmorItem;
/*    */ import fr.diskmth.literia.objects.items.AxeItem;
/*    */ import fr.diskmth.literia.objects.items.BasicItem;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ import net.minecraft.item.ItemSword;
/*    */ 
/*    */ public class ItemsInit {
/* 12 */   public static List<Item> ITEMS = new ArrayList<>();
/*    */ 
/*    */   
/* 15 */   public static Item COPPER = (Item)new BasicItem("copper");
/* 16 */   public static ItemSword COPPER_SWORD = (ItemSword)new SwordItem("copper_sword", ToolMaterialsInit.COPPER_TOOLS);
/* 17 */   public static ItemPickaxe COPPER_PICKAXE = (ItemPickaxe)new PickaxeItem("copper_pickaxe", ToolMaterialsInit.COPPER_TOOLS);
/* 18 */   public static AxeItem COPPER_AXE = new AxeItem("copper_axe", ToolMaterialsInit.COPPER_TOOLS);
/* 19 */   public static ItemSpade COPPER_SHOVEL = (ItemSpade)new ShovelItem("copper_shovel", ToolMaterialsInit.COPPER_TOOLS);
/* 20 */   public static ItemArmor COPPER_HELMET = (ItemArmor)new ArmorItem("copper_helmet", ToolMaterialsInit.COPPER_ARMOR, 1, EntityEquipmentSlot.HEAD);
/* 21 */   public static ItemArmor COPPER_CHESTPLATE = (ItemArmor)new ArmorItem("copper_chestplate", ToolMaterialsInit.COPPER_ARMOR, 1, EntityEquipmentSlot.CHEST);
/* 22 */   public static ItemArmor COPPER_LEGGING = (ItemArmor)new ArmorItem("copper_legging", ToolMaterialsInit.COPPER_ARMOR, 2, EntityEquipmentSlot.LEGS);
/* 23 */   public static ItemArmor COPPER_BOOTS = (ItemArmor)new ArmorItem("copper_boots", ToolMaterialsInit.COPPER_ARMOR, 1, EntityEquipmentSlot.FEET);
/*    */   
/* 25 */   public static Item TIN = (Item)new BasicItem("tin");
/* 26 */   public static ItemSword TIN_SWORD = (ItemSword)new SwordItem("tin_sword", ToolMaterialsInit.TIN_TOOLS);
/* 27 */   public static ItemPickaxe TIN_PICKAXE = (ItemPickaxe)new PickaxeItem("tin_pickaxe", ToolMaterialsInit.TIN_TOOLS);
/* 28 */   public static AxeItem TIN_AXE = new AxeItem("tin_axe", ToolMaterialsInit.TIN_TOOLS);
/* 29 */   public static ItemSpade TIN_SHOVEL = (ItemSpade)new ShovelItem("tin_shovel", ToolMaterialsInit.TIN_TOOLS);
/* 30 */   public static ItemArmor TIN_HELMET = (ItemArmor)new ArmorItem("tin_helmet", ToolMaterialsInit.TIN_ARMOR, 1, EntityEquipmentSlot.HEAD);
/* 31 */   public static ItemArmor TIN_CHESTPLATE = (ItemArmor)new ArmorItem("tin_chestplate", ToolMaterialsInit.TIN_ARMOR, 1, EntityEquipmentSlot.CHEST);
/* 32 */   public static ItemArmor TIN_LEGGING = (ItemArmor)new ArmorItem("tin_legging", ToolMaterialsInit.TIN_ARMOR, 2, EntityEquipmentSlot.LEGS);
/* 33 */   public static ItemArmor TIN_BOOTS = (ItemArmor)new ArmorItem("tin_boots", ToolMaterialsInit.TIN_ARMOR, 1, EntityEquipmentSlot.FEET);
/*    */   
/* 35 */   public static Item ISOLUA = (Item)new BasicItem("isolua");
/* 36 */   public static ItemSword ISOLUA_SWORD = (ItemSword)new SwordItem("isolua_sword", ToolMaterialsInit.ISOLUA_SWORD);
/* 37 */   public static ItemPickaxe ISOLUA_PICKAXE = (ItemPickaxe)new PickaxeItem("isolua_pickaxe", ToolMaterialsInit.ISOLUA_TOOLS);
/* 38 */   public static AxeItem ISOLUA_AXE = new AxeItem("isolua_axe", ToolMaterialsInit.ISOLUA_TOOLS);
/* 39 */   public static ItemSpade ISOLUA_SHOVEL = (ItemSpade)new ShovelItem("isolua_shovel", ToolMaterialsInit.ISOLUA_SHOVEL);
/* 40 */   public static ItemPickaxe ISOLUA_HAMMER = (ItemPickaxe)new HammerItem("isolua_hammer", ToolMaterialsInit.ISOLUA_HAMMER);
/* 41 */   public static ItemArmor ISOLUA_HELMET = (ItemArmor)new ArmorItem("isolua_helmet", ToolMaterialsInit.ISOLUA_ARMOR, 1, EntityEquipmentSlot.HEAD);
/* 42 */   public static ItemArmor ISOLUA_CHESTPLATE = (ItemArmor)new ArmorItem("isolua_chestplate", ToolMaterialsInit.ISOLUA_ARMOR, 1, EntityEquipmentSlot.CHEST);
/* 43 */   public static ItemArmor ISOLUA_LEGGING = (ItemArmor)new ArmorItem("isolua_legging", ToolMaterialsInit.ISOLUA_ARMOR, 2, EntityEquipmentSlot.LEGS);
/* 44 */   public static ItemArmor ISOLUA_BOOTS = (ItemArmor)new ArmorItem("isolua_boots", ToolMaterialsInit.ISOLUA_ARMOR, 1, EntityEquipmentSlot.FEET);
/*    */   
/* 46 */   public static Item LITERIUM = (Item)new BasicItem("literium");
/* 47 */   public static ItemSword LITERIUM_SWORD = (ItemSword)new SwordItem("literium_sword", ToolMaterialsInit.LITERIUM_SWORD);
/* 48 */   public static ItemPickaxe LITERIUM_PICKAXE = (ItemPickaxe)new PickaxeItem("literium_pickaxe", ToolMaterialsInit.LITERIUM_PICKAXE);
/* 49 */   public static AxeItem LITERIUM_AXE = new AxeItem("literium_axe", ToolMaterialsInit.LITERIUM_AXE);
/* 50 */   public static ItemSpade LITERIUM_SHOVEL = (ItemSpade)new ShovelItem("literium_shovel", ToolMaterialsInit.LITERIUM_SHOVEL);
/* 51 */   public static ItemHoe LITERIUM_HOE = (ItemHoe)new HoeItem("literium_hoe", ToolMaterialsInit.LITERIUM_HOE);
/* 52 */   public static ItemPickaxe LITERIUM_HAMMER = (ItemPickaxe)new HammerItem("literium_hammer", ToolMaterialsInit.LITERIUM_HAMMER);
/* 53 */   public static ItemShears LITERIUM_SHEARS = (ItemShears)new ShearsItem("literium_shears", 2000);
/* 54 */   public static ItemBow LITERIUM_BOW = (ItemBow)new BowItem("literium_bow", 751, 4.0D);
/* 55 */   public static ItemArmor LITERIUM_HELMET = (ItemArmor)new ArmorItem("literium_helmet", ToolMaterialsInit.LITERIUM_ARMOR, 1, EntityEquipmentSlot.HEAD);
/* 56 */   public static ItemArmor LITERIUM_CHESTPLATE = (ItemArmor)new ArmorItem("literium_chestplate", ToolMaterialsInit.LITERIUM_ARMOR, 1, EntityEquipmentSlot.CHEST);
/* 57 */   public static ItemArmor LITERIUM_LEGGING = (ItemArmor)new ArmorItem("literium_legging", ToolMaterialsInit.LITERIUM_ARMOR, 2, EntityEquipmentSlot.LEGS);
/* 58 */   public static ItemArmor LITERIUM_BOOTS = (ItemArmor)new ArmorItem("literium_boots", ToolMaterialsInit.LITERIUM_ARMOR, 1, EntityEquipmentSlot.FEET);
/* 59 */   public static Item LITERIUM_STICK = (Item)new BasicItem("literium_stick");
/*    */   
/* 61 */   public static Item DEMONITE = (Item)new BasicItem("demonite");
/* 62 */   public static ItemSword DEMONITE_SWORD = (ItemSword)new SwordItem("demonite_sword", ToolMaterialsInit.DEMONITE_SWORD);
/* 63 */   public static ItemPickaxe DEMONITE_PICKAXE = (ItemPickaxe)new PickaxeItem("demonite_pickaxe", ToolMaterialsInit.DEMONITE_PICKAXE);
/* 64 */   public static AxeItem DEMONITE_AXE = new AxeItem("demonite_axe", ToolMaterialsInit.DEMONITE_AXE);
/* 65 */   public static ItemSpade DEMONITE_SHOVEL = (ItemSpade)new ShovelItem("demonite_shovel", ToolMaterialsInit.DEMONITE_SHOVEL);
/* 66 */   public static ItemBow DEMONITE_BOW = (ItemBow)new BowItem("demonite_bow", 1000, 4.0D);
/* 67 */   public static ItemArmor DEMONITE_HELMET = (ItemArmor)new ArmorItem("demonite_helmet", ToolMaterialsInit.DEMONITE_ARMOR, 1, EntityEquipmentSlot.HEAD);
/* 68 */   public static ItemArmor DEMONITE_CHESTPLATE = (ItemArmor)new ArmorItem("demonite_chestplate", ToolMaterialsInit.DEMONITE_ARMOR, 1, EntityEquipmentSlot.CHEST);
/* 69 */   public static ItemArmor DEMONITE_LEGGING = (ItemArmor)new ArmorItem("demonite_legging", ToolMaterialsInit.DEMONITE_ARMOR, 2, EntityEquipmentSlot.LEGS);
/* 70 */   public static ItemArmor DEMONITE_BOOTS = (ItemArmor)new ArmorItem("demonite_boots", ToolMaterialsInit.DEMONITE_ARMOR, 1, EntityEquipmentSlot.FEET);
/* 71 */   public static Item DEMONITE_STICK = (Item)new BasicItem("demonite_stick");
/*    */   
/* 73 */   public static Item HEAL_ORB = (Item)new BasicItem("heal_orb");
/* 74 */   public static Item SPEED_ORB = (Item)new BasicItem("speed_orb");
/* 75 */   public static Item STRENGHT_ORB = (Item)new BasicItem("strenght_orb");
/* 76 */   public static Item LEGENDARY_ORB = (Item)new BasicItem("legendary_orb");
/*    */   
/* 78 */   public static Item HEAL_STICK = (Item)new StickItem("heal_stick", 10);
/* 79 */   public static Item SPEED_STICK = (Item)new StickItem("speed_stick", 10);
/* 80 */   public static Item STRENGHT_STICK = (Item)new StickItem("strenght_stick", 10);
/* 81 */   public static Item LEGENDARY_STICK = (Item)new StickItem("legendary_stick", 10);
/*    */   
/* 83 */   public static Item UNCLAIM_FINDER_LVL_1 = (Item)new UnclaimFinderItem("unclaim_finder_lvl_1", 2160000);
/* 84 */   public static Item UNCLAIM_FINDER_LVL_2 = (Item)new UnclaimFinderItem("unclaim_finder_lvl_2", 1440000);
/* 85 */   public static Item DYNAMITE = (Item)new DynamiteItem("dynamite");
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\init\ItemsInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */