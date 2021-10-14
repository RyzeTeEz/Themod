/*    */ package fr.diskmth.literia.client.render;
/*    */ 
/*    */ import fr.diskmth.literia.init.BlocksInit;
/*    */ import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.BlockRendererDispatcher;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPillerTNTPrimed
/*    */   extends Render<EntityPillerTNTPrimed>
/*    */ {
/*    */   public RenderPillerTNTPrimed(RenderManager renderManagerIn) {
/* 23 */     super(renderManagerIn);
/* 24 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(EntityPillerTNTPrimed entity, double x, double y, double z, float entityYaw, float partialTicks) {
/* 30 */     BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
/* 31 */     GlStateManager.func_179094_E();
/* 32 */     GlStateManager.func_179109_b((float)x, (float)y + 0.5F, (float)z);
/*    */     
/* 34 */     if (entity.getFuse() - partialTicks + 1.0F < 10.0F) {
/*    */       
/* 36 */       float f = 1.0F - (entity.getFuse() - partialTicks + 1.0F) / 10.0F;
/* 37 */       f = MathHelper.func_76131_a(f, 0.0F, 1.0F);
/* 38 */       f *= f;
/* 39 */       f *= f;
/* 40 */       float f1 = 1.0F + f * 0.3F;
/* 41 */       GlStateManager.func_179152_a(f1, f1, f1);
/*    */     } 
/*    */     
/* 44 */     float f2 = (1.0F - (entity.getFuse() - partialTicks + 1.0F) / 100.0F) * 0.8F;
/* 45 */     func_180548_c((Entity)entity);
/* 46 */     GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
/* 47 */     GlStateManager.func_179109_b(-0.5F, -0.5F, 0.5F);
/* 48 */     blockrendererdispatcher.func_175016_a(BlocksInit.PILLER_TNT.func_176223_P(), entity.func_70013_c());
/* 49 */     GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
/*    */     
/* 51 */     if (this.field_188301_f) {
/*    */       
/* 53 */       GlStateManager.func_179142_g();
/* 54 */       GlStateManager.func_187431_e(func_188298_c((Entity)entity));
/* 55 */       blockrendererdispatcher.func_175016_a(BlocksInit.PILLER_TNT.func_176223_P(), 1.0F);
/* 56 */       GlStateManager.func_187417_n();
/* 57 */       GlStateManager.func_179119_h();
/*    */     }
/* 59 */     else if (entity.getFuse() / 5 % 2 == 0) {
/*    */       
/* 61 */       GlStateManager.func_179090_x();
/* 62 */       GlStateManager.func_179140_f();
/* 63 */       GlStateManager.func_179147_l();
/* 64 */       GlStateManager.func_187401_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.DST_ALPHA);
/* 65 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, f2);
/* 66 */       GlStateManager.func_179136_a(-3.0F, -3.0F);
/* 67 */       GlStateManager.func_179088_q();
/* 68 */       blockrendererdispatcher.func_175016_a(BlocksInit.PILLER_TNT.func_176223_P(), 1.0F);
/* 69 */       GlStateManager.func_179136_a(0.0F, 0.0F);
/* 70 */       GlStateManager.func_179113_r();
/* 71 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 72 */       GlStateManager.func_179084_k();
/* 73 */       GlStateManager.func_179145_e();
/* 74 */       GlStateManager.func_179098_w();
/*    */     } 
/*    */     
/* 77 */     GlStateManager.func_179121_F();
/* 78 */     super.func_76986_a((Entity)entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityPillerTNTPrimed entity) {
/* 84 */     return TextureMap.field_110575_b;
/*    */   }
/*    */   
/*    */   public static class RenderFactory
/*    */     implements IRenderFactory<Entity>
/*    */   {
/*    */     public Render createRenderFor(RenderManager manager) {
/* 91 */       return new RenderPillerTNTPrimed(manager);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\client\render\RenderPillerTNTPrimed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */