/*    */ package fr.diskmth.literia.init;
/*    */ 
/*    */ import fr.diskmth.literia.client.render.RenderPillerTNTPrimed;
/*    */ import fr.diskmth.literia.objects.entity.EntityDynamite;
/*    */ import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.entity.RenderSnowball;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ 
/*    */ public class RendersInit {
/*    */   public static void registerRenders() {
/* 16 */     registerRenderer((Class)EntityPillerTNTPrimed.class, (IRenderFactory<Entity>)new RenderPillerTNTPrimed.RenderFactory());
/* 17 */     RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, renderManager -> new RenderSnowball(renderManager, ItemsInit.DYNAMITE, Minecraft.func_71410_x().func_175599_af()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void registerRenderer(Class<? extends Entity> entity, IRenderFactory<Entity> render) {
/* 23 */     RenderingRegistry.registerEntityRenderingHandler(entity, render);
/*    */   }
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\init\RendersInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */