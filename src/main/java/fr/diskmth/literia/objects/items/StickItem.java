/*     */ package fr.diskmth.literia.objects.items;
/*     */ 
/*     */ import fr.diskmth.literia.Main;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class StickItem extends Item implements IHasModel {
/*  18 */   private String typeOfStick = "";
/*     */ 
/*     */ 
/*     */   
/*     */   public StickItem(String name, int MaxDamage) {
/*  23 */     func_77655_b(name);
/*  24 */     setRegistryName(name);
/*  25 */     func_77625_d(1);
/*  26 */     this.typeOfStick = name;
/*  27 */     func_77656_e(MaxDamage - 1);
/*  28 */     func_77637_a(null);
/*  29 */     ItemsInit.ITEMS.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> func_77659_a(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
/*  35 */     if (this.typeOfStick.contains("heal")) {
/*     */       
/*  37 */       ItemStack stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
/*     */       
/*  39 */       if (!worldIn.field_72995_K) {
/*     */         
/*  41 */         if (playerIn.func_110143_aJ() == 20.0F)
/*     */         {
/*  43 */           return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
/*     */         }
/*     */ 
/*     */         
/*  47 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76432_h, 1, 2));
/*  48 */         stack.func_77972_a(1, (EntityLivingBase)playerIn);
/*  49 */         if (!playerIn.field_71075_bZ.field_75098_d)
/*     */         {
/*  51 */           playerIn.func_184811_cZ().func_185145_a(this, 300);
/*     */         }
/*  53 */         return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  58 */       return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     if (this.typeOfStick.contains("speed")) {
/*     */       
/*  66 */       ItemStack stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
/*     */       
/*  68 */       if (!worldIn.field_72995_K) {
/*     */         
/*  70 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 140, 2));
/*  71 */         stack.func_77972_a(1, (EntityLivingBase)playerIn);
/*  72 */         if (!playerIn.field_71075_bZ.field_75098_d)
/*     */         {
/*  74 */           playerIn.func_184811_cZ().func_185145_a(this, 300);
/*     */         }
/*  76 */         return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
/*     */       } 
/*     */ 
/*     */       
/*  80 */       return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (this.typeOfStick.contains("strenght")) {
/*     */       
/*  88 */       ItemStack stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
/*     */       
/*  90 */       if (!worldIn.field_72995_K) {
/*     */         
/*  92 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 200, 1));
/*  93 */         stack.func_77972_a(1, (EntityLivingBase)playerIn);
/*  94 */         if (!playerIn.field_71075_bZ.field_75098_d)
/*     */         {
/*  96 */           playerIn.func_184811_cZ().func_185145_a(this, 300);
/*     */         }
/*  98 */         return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
/*     */       } 
/*     */ 
/*     */       
/* 102 */       return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (this.typeOfStick.contains("legendary")) {
/*     */       
/* 110 */       ItemStack stack = playerIn.func_184586_b(EnumHand.MAIN_HAND);
/*     */       
/* 112 */       if (!worldIn.field_72995_K) {
/*     */         
/* 114 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76432_h, 1, 1));
/* 115 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 140, 2));
/* 116 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 100, 2));
/* 117 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76422_e, 160, 1));
/* 118 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76428_l, 300, 1));
/* 119 */         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76444_x, 2400, 1));
/* 120 */         stack.func_77972_a(1, (EntityLivingBase)playerIn);
/* 121 */         if (!playerIn.field_71075_bZ.field_75098_d)
/*     */         {
/* 123 */           playerIn.func_184811_cZ().func_185145_a(this, 600);
/*     */         }
/* 125 */         return new ActionResult(EnumActionResult.SUCCESS, playerIn.func_184586_b(handIn));
/*     */       } 
/*     */ 
/*     */       
/* 129 */       return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
/*     */     } 
/*     */ 
/*     */     
/* 133 */     return new ActionResult(EnumActionResult.PASS, playerIn.func_184586_b(handIn));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77616_k(ItemStack stack) {
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerModels() {
/* 145 */     Main.proxy.registerItemRenderer(this, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\items\StickItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */