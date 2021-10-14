/*    */ package fr.diskmth.literia.objects.items;
/*    */ 
/*    */ import fr.diskmth.literia.Main;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.objects.entity.EntityDynamite;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.SoundEvents;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.EnumActionResult;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.SoundCategory;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class DynamiteItem
/*    */   extends Item implements IHasModel {
/*    */   public DynamiteItem(String name) {
/* 22 */     func_77655_b(name);
/* 23 */     setRegistryName(name);
/* 24 */     func_77637_a(null);
/* 25 */     ItemsInit.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionResult<ItemStack> func_77659_a(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
/* 31 */     ItemStack stack = playerIn.func_184586_b(handIn);
/*    */     
/* 33 */     if (!worldIn.field_72995_K) {
/*    */       
/* 35 */       if (!playerIn.field_71075_bZ.field_75098_d)
/*    */       {
/* 37 */         stack.func_190918_g(1);
/*    */       }
/*    */       
/* 40 */       worldIn.func_184148_a((EntityPlayer)null, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, SoundEvents.field_187797_fA, SoundCategory.NEUTRAL, 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
/*    */       
/* 42 */       EntityDynamite entityDynamite = new EntityDynamite(worldIn, (EntityLivingBase)playerIn);
/* 43 */       entityDynamite.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0F, 1.5F, 1.0F);
/* 44 */       worldIn.func_72838_d((Entity)entityDynamite);
/* 45 */       return new ActionResult(EnumActionResult.SUCCESS, stack);
/*    */     } 
/*    */     
/* 48 */     return new ActionResult(EnumActionResult.PASS, stack);
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 53 */     Main.proxy.registerItemRenderer(this, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\items\DynamiteItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */