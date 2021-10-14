package fr.diskmth.literia.init;

import fr.diskmth.literia.client.render.RenderPillerTNTPrimed;
import fr.diskmth.literia.objects.entity.EntityDynamite;
import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RendersInit {
   public static void registerRenders() {
      registerRenderer(EntityPillerTNTPrimed.class, new RenderPillerTNTPrimed.RenderFactory());
      RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, (renderManager) -> {
         return new RenderSnowball(renderManager, ItemsInit.DYNAMITE, Minecraft.func_71410_x().func_175599_af());
      });
   }

   private static void registerRenderer(Class entity, IRenderFactory render) {
      RenderingRegistry.registerEntityRenderingHandler(entity, render);
   }
}
