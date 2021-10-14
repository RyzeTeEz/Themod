/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.IItemPropertyGetter;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class UnclaimFinderItem
/*    */   extends Item implements IHasModel {
/*    */   private static EntityPlayer player;
/*    */   private static int dura;
/* 22 */   public static int percents = 0;
/*    */ 
/*    */   
/*    */   public UnclaimFinderItem(String name, int maxDamage) {
/* 26 */     func_185043_a(new ResourceLocation("percent"), new IItemPropertyGetter()
/*    */         {
/*    */ 
/*    */           
/*    */           @SideOnly(Side.CLIENT)
/*    */           public float func_185085_a(ItemStack stack, World worldIn, EntityLivingBase entityIn)
/*    */           {
/* 33 */             return UnclaimFinderItem.percents;
/*    */           }
/*    */         });
/*    */     
/* 37 */     func_77656_e(maxDamage);
/* 38 */     func_77655_b(name);
/* 39 */     setRegistryName(name);
/* 40 */     func_77625_d(1);
/* 41 */     func_77637_a(null);
/* 42 */     this; dura = maxDamage;
/* 43 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
/* 49 */     this; player = (EntityPlayer)entityIn;
/*    */     
/* 51 */     this; if (player.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() instanceof UnclaimFinderItem) {
/*    */       
/* 53 */       this; if (dura >= 0) {
/*    */         
/* 55 */         this; dura--;
/* 56 */         stack.func_77972_a(1, (EntityLivingBase)player);
/*    */       } 
/*    */     } 
/*    */     
/* 60 */     super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77616_k(ItemStack stack) {
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 72 */     Main.proxy.registerItemRenderer(this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\items\UnclaimFinderItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */