package fr.diskmth.literia;

import fr.diskmth.literia.client.gui.GuiUnclaimFinder;
import fr.diskmth.literia.init.RendersInit;
import fr.diskmth.literia.utils.handlers.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
   modid = "literiamod",
   name = "Mod Literia",
   version = "1.0"
)
public class Main {
   @SidedProxy(
      clientSide = "fr.diskmth.literia.Main$ClientProxy",
      serverSide = "fr.diskmth.literia.Main$CommonProxy"
   )
   public static Main.CommonProxy proxy;
   public static Logger logger;

   @EventHandler
   public static void preInit(FMLPreInitializationEvent e) throws Exception {
      if (e.getSide().isClient() && !Minecraft.getMinecraft().gameDir.getPath().contains(".Literia")) {
         ;
      }

      logger = e.getModLog();
      proxy.preInit();
      proxy.init();
      RegistryHandler.preInitRegistries();
   }

   @EventHandler
   public static void init(FMLInitializationEvent e) {
      RegistryHandler.initRegistries();
   }

   @EventHandler
   public static void postInit(FMLPostInitializationEvent e) {
      RegistryHandler.postInitRegistries();
   }

   public static class ClientProxy extends Main.CommonProxy {
      public void registerItemRenderer(Item item, int meta) {
         ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
      }

      public void registerVariantRenderer(Item item, int meta, String filename, String id) {
         super.registerVariantRenderer(item, meta, filename, id);
      }

      public void registerEntityRenderers() {
         super.registerEntityRenderers();
      }

      public void preInit() {
         super.preInit();
      }

      public void init() {
         super.init();
         RendersInit.registerRenders();
         MinecraftForge.EVENT_BUS.register(new GuiUnclaimFinder());
      }
   }

   public static class CommonProxy {
      public void registerItemRenderer(Item item, int meta) {
      }

      public void registerVariantRenderer(Item item, int meta, String filename, String id) {
      }

      public void registerEntityRenderers() {
      }

      public void preInit() {
      }

      public void init() {
      }
   }
}
