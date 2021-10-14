/*     */ package fr.diskmth.literia.objects.items;
/*     */ 
/*     */ import fr.diskmth.literia.Main;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.IItemPropertyGetter;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArrow;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ public class BowItem
/*     */   extends ItemBow
/*     */   implements IHasModel
/*     */ {
/*  35 */   private String typeOfBow = "";
/*     */   
/*     */   private double damage;
/*     */   
/*     */   public BowItem(String name, int maxDamage, double damage) {
/*  40 */     func_77655_b(name);
/*  41 */     setRegistryName(name);
/*  42 */     func_77625_d(1);
/*  43 */     func_77656_e(maxDamage);
/*  44 */     func_77637_a(null);
/*  45 */     this.typeOfBow = name;
/*  46 */     this.damage = damage;
/*  47 */     ItemsInit.ITEMS.add(this);
/*  48 */     func_185043_a(new ResourceLocation("pulling"), new IItemPropertyGetter()
/*     */         {
/*     */           @SideOnly(Side.CLIENT)
/*     */           public float func_185085_a(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
/*     */           {
/*  53 */             return (entityIn != null && entityIn.func_184587_cr() && entityIn.func_184607_cu() == stack) ? 1.0F : 0.0F;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_185060_a(EntityPlayer player) {
/*  61 */     if (func_185058_h_(player.func_184586_b(EnumHand.OFF_HAND)))
/*     */     {
/*  63 */       return player.func_184586_b(EnumHand.OFF_HAND);
/*     */     }
/*  65 */     if (func_185058_h_(player.func_184586_b(EnumHand.MAIN_HAND)))
/*     */     {
/*  67 */       return player.func_184586_b(EnumHand.MAIN_HAND);
/*     */     }
/*     */ 
/*     */     
/*  71 */     for (int i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
/*     */       
/*  73 */       ItemStack itemstack = player.field_71071_by.func_70301_a(i);
/*     */       
/*  75 */       if (func_185058_h_(itemstack))
/*     */       {
/*  77 */         return itemstack;
/*     */       }
/*     */     } 
/*     */     
/*  81 */     return ItemStack.field_190927_a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getZoom(EntityLivingBase entity) {
/*  87 */     return (1 - MathHelper.func_76125_a(func_77626_a(null) - entity.func_184605_cv(), 0, 20) / 60);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getArrowVelocity(int charge) {
/*  92 */     float f = charge / 20.0F;
/*  93 */     f = (f * f + f * 2.0F) / 3.0F;
/*     */     
/*  95 */     if (f > 1.0F)
/*     */     {
/*  97 */       f = 1.0F;
/*     */     }
/*     */     
/* 100 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77615_a(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
/* 105 */     if (entityLiving instanceof EntityPlayer) {
/*     */       
/* 107 */       EntityPlayer entityplayer = (EntityPlayer)entityLiving;
/* 108 */       boolean flag = (entityplayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantments.field_185312_x, stack) > 0);
/* 109 */       ItemStack itemstack = func_185060_a(entityplayer);
/*     */       
/* 111 */       int i = func_77626_a(stack) - timeLeft;
/* 112 */       i = ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, (!itemstack.func_190926_b() || flag));
/* 113 */       if (i < 0) {
/*     */         return;
/*     */       }
/* 116 */       if (!itemstack.func_190926_b() || flag) {
/*     */         
/* 118 */         if (itemstack.func_190926_b())
/*     */         {
/* 120 */           itemstack = new ItemStack(Items.field_151032_g);
/*     */         }
/*     */         
/* 123 */         float f = getArrowVelocity(i);
/*     */         
/* 125 */         if (f >= 0.1D) {
/*     */           
/* 127 */           boolean flag1 = (entityplayer.field_71075_bZ.field_75098_d || (itemstack.func_77973_b() instanceof ItemArrow && ((ItemArrow)itemstack.func_77973_b()).isInfinite(itemstack, stack, entityplayer)));
/*     */           
/* 129 */           if (!worldIn.field_72995_K) {
/*     */             
/* 131 */             ItemArrow itemarrow = (itemstack.func_77973_b() instanceof ItemArrow) ? (ItemArrow)itemstack.func_77973_b() : (ItemArrow)Items.field_151032_g;
/* 132 */             EntityArrow entityarrow = itemarrow.func_185052_a(worldIn, itemstack, (EntityLivingBase)entityplayer);
/* 133 */             entityarrow.func_184547_a((Entity)entityplayer, entityplayer.field_70125_A, entityplayer.field_70177_z, 0.0F, f * 3.0F, 1.0F);
/* 134 */             entityarrow.func_70239_b(this.damage);
/*     */             
/* 136 */             if (f == 1.0F)
/*     */             {
/* 138 */               entityarrow.func_70243_d(true);
/*     */             }
/*     */             
/* 141 */             int j = EnchantmentHelper.func_77506_a(Enchantments.field_185309_u, stack);
/*     */             
/* 143 */             if (j > 0)
/*     */             {
/* 145 */               entityarrow.func_70239_b(entityarrow.func_70242_d() + j * 0.5D + 0.5D);
/*     */             }
/*     */             
/* 148 */             int k = EnchantmentHelper.func_77506_a(Enchantments.field_185310_v, stack);
/*     */             
/* 150 */             if (k > 0)
/*     */             {
/* 152 */               entityarrow.func_70240_a(k);
/*     */             }
/*     */             
/* 155 */             if (EnchantmentHelper.func_77506_a(Enchantments.field_185311_w, stack) > 0)
/*     */             {
/* 157 */               entityarrow.func_70015_d(100);
/*     */             }
/*     */             
/* 160 */             stack.func_77972_a(1, (EntityLivingBase)entityplayer);
/*     */             
/* 162 */             if (flag1 || (entityplayer.field_71075_bZ.field_75098_d && (itemstack.func_77973_b() == Items.field_185166_h || itemstack.func_77973_b() == Items.field_185167_i)))
/*     */             {
/* 164 */               entityarrow.field_70251_a = EntityArrow.PickupStatus.CREATIVE_ONLY;
/*     */             }
/*     */             
/* 167 */             worldIn.func_72838_d((Entity)entityarrow);
/*     */           } 
/*     */           
/* 170 */           worldIn.func_184148_a((EntityPlayer)null, entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, SoundEvents.field_187737_v, SoundCategory.PLAYERS, 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
/*     */           
/* 172 */           if (!flag1 && !entityplayer.field_71075_bZ.field_75098_d) {
/*     */             
/* 174 */             itemstack.func_190918_g(1);
/*     */             
/* 176 */             if (itemstack.func_190926_b())
/*     */             {
/* 178 */               entityplayer.field_71071_by.func_184437_d(itemstack);
/*     */             }
/*     */           } 
/*     */           
/* 182 */           entityplayer.func_71029_a(StatList.func_188057_b((Item)this));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77622_d(ItemStack stack, World worldIn, EntityPlayer playerIn) {
/* 191 */     if (this.typeOfBow.contains("literium")) {
/*     */       
/* 193 */       stack.func_77966_a(Enchantments.field_185309_u, 2);
/*     */     
/*     */     }
/* 196 */     else if (this.typeOfBow.contains("demonite")) {
/*     */       
/* 198 */       stack.func_77966_a(Enchantments.field_185309_u, 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/* 204 */     if (this.typeOfBow.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*     */     {
/* 206 */       return true;
/*     */     }
/*     */     
/* 209 */     if (this.typeOfBow.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE)
/*     */     {
/* 211 */       return true;
/*     */     }
/*     */     
/* 214 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerModels() {
/* 220 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\items\BowItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */