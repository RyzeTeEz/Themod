package fr.diskmth.literia.utils.handlers;

import fr.diskmth.literia.init.BlocksInit;
import fr.diskmth.literia.init.CreativeTabsInit;
import fr.diskmth.literia.init.EntityInit;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.init.NetworkInit;
import fr.diskmth.literia.init.RecipesInit;
import fr.diskmth.literia.init.ToolMaterialsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import fr.diskmth.literia.world.WorldGenOres;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber
public class RegistryHandler {
   @SubscribeEvent
   public static void onItemRegister(Register event) {
      event.getRegistry().registerAll((IForgeRegistryEntry[])ItemsInit.ITEMS.toArray(new Item[0]));
   }

   @SubscribeEvent
   public static void onBlockRegister(Register event) {
      event.getRegistry().registerAll((IForgeRegistryEntry[])BlocksInit.BLOCKS.toArray(new Block[0]));
   }

   @SubscribeEvent
   public static void onModelRegister(ModelRegistryEvent event) {
      Iterator var1 = ItemsInit.ITEMS.iterator();

      while(var1.hasNext()) {
         Item item = (Item)var1.next();
         if (item instanceof IHasModel) {
            ((IHasModel)item).registerModels();
         }
      }

      var1 = BlocksInit.BLOCKS.iterator();

      while(var1.hasNext()) {
         Block block = (Block)var1.next();
         if (block instanceof IHasModel) {
            ((IHasModel)block).registerModels();
         }
      }

   }

   public static void preInitRegistries() {
      ToolMaterialsInit.registerToolMaterials();
      CreativeTabsInit.registerCreativetabs();
      EntityInit.registerEntity();
   }

   public static void initRegistries() {
      RecipesInit.registerRecipes();
      GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
      MinecraftForge.EVENT_BUS.register(new EventHandler());
      NetworkInit.registerNetwork();
   }

   public static void postInitRegistries() {
   }
}
