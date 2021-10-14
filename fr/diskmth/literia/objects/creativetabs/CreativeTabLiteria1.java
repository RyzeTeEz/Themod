/*     */ package fr.diskmth.literia.objects.creativetabs;
/*     */ 
/*     */ import fr.diskmth.literia.init.BlocksInit;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class CreativeTabLiteria1
/*     */   extends CreativeTabs {
/*     */   public CreativeTabLiteria1(String name) {
/*  15 */     super(name);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ItemStack func_78016_d() {
/*  20 */     return new ItemStack((Item)ItemsInit.DEMONITE_PICKAXE);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean hasSearchBar() {
/*  25 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_78018_a(NonNullList<ItemStack> list) {
/*  30 */     super.func_78018_a(list);
/*     */ 
/*     */     
/*  33 */     list.add(new ItemStack(ItemsInit.COPPER));
/*  34 */     list.add(new ItemStack(BlocksInit.COPPER_BLOCK));
/*  35 */     list.add(new ItemStack(BlocksInit.COPPER_ORE));
/*  36 */     list.add(new ItemStack((Item)ItemsInit.COPPER_SWORD));
/*  37 */     list.add(new ItemStack((Item)ItemsInit.COPPER_PICKAXE));
/*  38 */     list.add(new ItemStack((Item)ItemsInit.COPPER_AXE));
/*  39 */     list.add(new ItemStack((Item)ItemsInit.COPPER_SHOVEL));
/*  40 */     list.add(new ItemStack((Item)ItemsInit.COPPER_HELMET));
/*  41 */     list.add(new ItemStack((Item)ItemsInit.COPPER_CHESTPLATE));
/*  42 */     list.add(new ItemStack((Item)ItemsInit.COPPER_LEGGING));
/*  43 */     list.add(new ItemStack((Item)ItemsInit.COPPER_BOOTS));
/*     */     
/*  45 */     list.add(new ItemStack(ItemsInit.TIN));
/*  46 */     list.add(new ItemStack(BlocksInit.TIN_BLOCK));
/*  47 */     list.add(new ItemStack(BlocksInit.TIN_ORE));
/*  48 */     list.add(new ItemStack((Item)ItemsInit.TIN_SWORD));
/*  49 */     list.add(new ItemStack((Item)ItemsInit.TIN_PICKAXE));
/*  50 */     list.add(new ItemStack((Item)ItemsInit.TIN_AXE));
/*  51 */     list.add(new ItemStack((Item)ItemsInit.TIN_SHOVEL));
/*  52 */     list.add(new ItemStack((Item)ItemsInit.TIN_HELMET));
/*  53 */     list.add(new ItemStack((Item)ItemsInit.TIN_CHESTPLATE));
/*  54 */     list.add(new ItemStack((Item)ItemsInit.TIN_LEGGING));
/*  55 */     list.add(new ItemStack((Item)ItemsInit.TIN_BOOTS));
/*     */     
/*  57 */     list.add(new ItemStack(ItemsInit.ISOLUA));
/*  58 */     list.add(new ItemStack(BlocksInit.ISOLUA_BLOCK));
/*  59 */     list.add(new ItemStack(BlocksInit.ISOLUA_ORE));
/*  60 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_SWORD));
/*  61 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_PICKAXE));
/*  62 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_AXE));
/*  63 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_SHOVEL));
/*  64 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_HAMMER));
/*  65 */     list.add(new ItemStack(BlocksInit.ISOLUA_LADDER));
/*  66 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_HELMET));
/*  67 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_CHESTPLATE));
/*  68 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_LEGGING));
/*  69 */     list.add(new ItemStack((Item)ItemsInit.ISOLUA_BOOTS));
/*     */     
/*  71 */     list.add(new ItemStack(ItemsInit.LITERIUM));
/*  72 */     list.add(new ItemStack(BlocksInit.LITERIUM_BLOCK));
/*  73 */     list.add(new ItemStack(BlocksInit.LITERIUM_ORE));
/*  74 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_SWORD));
/*  75 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_PICKAXE));
/*  76 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_AXE));
/*  77 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_SHOVEL));
/*  78 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_HOE));
/*  79 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_HAMMER));
/*  80 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_SHEARS));
/*  81 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_BOW));
/*  82 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_HELMET));
/*  83 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_CHESTPLATE));
/*  84 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_LEGGING));
/*  85 */     list.add(new ItemStack((Item)ItemsInit.LITERIUM_BOOTS));
/*  86 */     list.add(new ItemStack(ItemsInit.LITERIUM_STICK));
/*     */     
/*  88 */     list.add(new ItemStack(ItemsInit.DEMONITE));
/*  89 */     list.add(new ItemStack(BlocksInit.DEMONITE_BLOCK));
/*  90 */     list.add(new ItemStack(BlocksInit.DEMONITE_ORE));
/*  91 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_SWORD));
/*  92 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_PICKAXE));
/*  93 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_AXE));
/*  94 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_SHOVEL));
/*  95 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_BOW));
/*  96 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_HELMET));
/*  97 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_CHESTPLATE));
/*  98 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_LEGGING));
/*  99 */     list.add(new ItemStack((Item)ItemsInit.DEMONITE_BOOTS));
/* 100 */     list.add(new ItemStack(ItemsInit.DEMONITE_STICK));
/*     */     
/* 102 */     list.add(new ItemStack(ItemsInit.HEAL_ORB));
/* 103 */     list.add(new ItemStack(ItemsInit.SPEED_ORB));
/* 104 */     list.add(new ItemStack(ItemsInit.STRENGHT_ORB));
/* 105 */     list.add(new ItemStack(ItemsInit.LEGENDARY_ORB));
/*     */     
/* 107 */     list.add(new ItemStack(ItemsInit.HEAL_STICK));
/* 108 */     list.add(new ItemStack(ItemsInit.SPEED_STICK));
/* 109 */     list.add(new ItemStack(ItemsInit.STRENGHT_STICK));
/* 110 */     list.add(new ItemStack(ItemsInit.LEGENDARY_STICK));
/*     */     
/* 112 */     list.add(new ItemStack(BlocksInit.PILLER_TNT));
/* 113 */     list.add(new ItemStack(BlocksInit.CAVE_BLOCK));
/* 114 */     list.add(new ItemStack(ItemsInit.UNCLAIM_FINDER_LVL_1));
/* 115 */     list.add(new ItemStack(ItemsInit.UNCLAIM_FINDER_LVL_2));
/* 116 */     list.add(new ItemStack(ItemsInit.DYNAMITE));
/*     */   }
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\creativetabs\CreativeTabLiteria1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */