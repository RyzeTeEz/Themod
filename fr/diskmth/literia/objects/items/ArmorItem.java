/*     */ package fr.diskmth.literia.objects.items;
/*     */ 
/*     */ import fr.diskmth.literia.Main;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ArmorItem extends ItemArmor implements IHasModel {
/*  18 */   private String typeOfArmor = "";
/*     */ 
/*     */   
/*     */   public ArmorItem(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/*  22 */     super(materialIn, renderIndexIn, equipmentSlotIn);
/*  23 */     func_77655_b(name);
/*  24 */     setRegistryName(name);
/*  25 */     this.typeOfArmor = name;
/*  26 */     func_77637_a(null);
/*  27 */     ItemsInit.ITEMS.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
/*  33 */     ItemStack helmet = player.func_184582_a(EntityEquipmentSlot.HEAD);
/*  34 */     ItemStack chestplate = player.func_184582_a(EntityEquipmentSlot.CHEST);
/*  35 */     ItemStack legging = player.func_184582_a(EntityEquipmentSlot.LEGS);
/*  36 */     ItemStack boots = player.func_184582_a(EntityEquipmentSlot.FEET);
/*     */     
/*  38 */     if (!world.field_72995_K) {
/*     */       
/*     */       try {
/*     */         
/*  42 */         if ((helmet.func_77973_b() == ItemsInit.LITERIUM_HELMET || helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET) && player.func_70660_b(Potion.func_188412_a(16)).func_76459_b() < 220)
/*     */         {
/*  44 */           player.func_70690_d(new PotionEffect(MobEffects.field_76439_r, 300, 0));
/*     */         }
/*     */         
/*  47 */         if ((boots.func_77973_b() == ItemsInit.LITERIUM_BOOTS || boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS) && player.func_70660_b(Potion.func_188412_a(1)).func_76459_b() < 220)
/*     */         {
/*  49 */           player.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 300, 0));
/*     */         }
/*     */         
/*  52 */         if (helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET && chestplate.func_77973_b() == ItemsInit.DEMONITE_CHESTPLATE && legging.func_77973_b() == ItemsInit.DEMONITE_LEGGING && boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS && player.func_70660_b(Potion.func_188412_a(14)).func_76459_b() < 220)
/*     */         {
/*  54 */           player.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 300, 0));
/*     */         }
/*     */       }
/*  57 */       catch (NullPointerException e) {
/*     */         
/*  59 */         if (helmet.func_77973_b() == ItemsInit.LITERIUM_HELMET || helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET)
/*     */         {
/*  61 */           player.func_70690_d(new PotionEffect(MobEffects.field_76439_r, 300, 0));
/*     */         }
/*     */         
/*  64 */         if (boots.func_77973_b() == ItemsInit.LITERIUM_BOOTS || boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS)
/*     */         {
/*  66 */           player.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 300, 0));
/*     */         }
/*     */         
/*  69 */         if (helmet.func_77973_b() == ItemsInit.DEMONITE_HELMET && chestplate.func_77973_b() == ItemsInit.DEMONITE_CHESTPLATE && legging.func_77973_b() == ItemsInit.DEMONITE_LEGGING && boots.func_77973_b() == ItemsInit.DEMONITE_BOOTS)
/*     */         {
/*  71 */           player.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 300, 0));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/*  79 */     if (this.typeOfArmor.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER)
/*     */     {
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     if (this.typeOfArmor.contains("tin") && repair.func_77973_b() == ItemsInit.TIN)
/*     */     {
/*  86 */       return true;
/*     */     }
/*     */     
/*  89 */     if (this.typeOfArmor.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA)
/*     */     {
/*  91 */       return true;
/*     */     }
/*     */     
/*  94 */     if (this.typeOfArmor.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*     */     {
/*  96 */       return true;
/*     */     }
/*     */     
/*  99 */     if (this.typeOfArmor.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE)
/*     */     {
/* 101 */       return true;
/*     */     }
/*     */     
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77622_d(ItemStack stack, World worldIn, EntityPlayer playerIn) {
/* 110 */     if (this.typeOfArmor.contains("demonite_helmet")) {
/*     */       
/* 112 */       stack.func_77966_a(Enchantments.field_180310_c, 4);
/* 113 */       stack.func_77966_a(Enchantments.field_77329_d, 6);
/*     */     
/*     */     }
/* 116 */     else if (this.typeOfArmor.contains("demonite_chestplate")) {
/*     */       
/* 118 */       stack.func_77966_a(Enchantments.field_180310_c, 4);
/* 119 */       stack.func_77966_a(Enchantments.field_77329_d, 6);
/*     */     
/*     */     }
/* 122 */     else if (this.typeOfArmor.contains("demonite_legging")) {
/*     */       
/* 124 */       stack.func_77966_a(Enchantments.field_180310_c, 4);
/* 125 */       stack.func_77966_a(Enchantments.field_77329_d, 6);
/*     */     
/*     */     }
/* 128 */     else if (this.typeOfArmor.contains("demonite_boots")) {
/*     */       
/* 130 */       stack.func_77966_a(Enchantments.field_180310_c, 4);
/* 131 */       stack.func_77966_a(Enchantments.field_77329_d, 6);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerModels() {
/* 137 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\items\ArmorItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */