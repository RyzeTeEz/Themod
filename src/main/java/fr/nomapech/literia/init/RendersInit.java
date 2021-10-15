package fr.nomapech.literia.init;

import fr.nomapech.literia.client.render.RenderPillerTNTPrimed;
import fr.nomapech.literia.objects.entity.EntityDynamite;
import fr.nomapech.literia.objects.entity.EntityPillerTNTPrimed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RendersInit {
   public static void registerRenders() {
      registerRenderer(EntityPillerTNTPrimed.class, new RenderPillerTNTPrimed.RenderFactory());
      RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, (renderManager) -> {
         return new RenderSnowball(renderManager, ItemsInit.DYNAMITE, Minecraft.getMinecraft().getRenderItem());
      });
   }

   private static void registerRenderer(Class entity, IRenderFactory render) {
      RenderingRegistry.registerEntityRenderingHandler(entity, render);
   }
}
