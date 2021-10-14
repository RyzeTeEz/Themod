/*    */ package fr.diskmth.literia.utils.handlers;
/*    */ import fr.diskmth.literia.init.BlocksInit;
/*    */ import fr.diskmth.literia.init.EntityInit;
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import fr.diskmth.literia.init.NetworkInit;
/*    */ import fr.diskmth.literia.init.ToolMaterialsInit;
/*    */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*    */ import fr.diskmth.literia.world.WorldGenOres;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class RegistryHandler {
/*    */   @SubscribeEvent
/*    */   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 21 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ItemsInit.ITEMS.toArray((Object[])new Item[0]));
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onBlockRegister(RegistryEvent.Register<Block> event) {
/* 27 */     event.getRegistry().registerAll((IForgeRegistryEntry[])BlocksInit.BLOCKS.toArray((Object[])new Block[0]));
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onModelRegister(ModelRegistryEvent event) {
/* 33 */     for (Item item : ItemsInit.ITEMS) {
/*    */       
/* 35 */       if (item instanceof IHasModel)
/*    */       {
/* 37 */         ((IHasModel)item).registerModels();
/*    */       }
/*    */     } 
/*    */     
/* 41 */     for (Block block : BlocksInit.BLOCKS) {
/*    */       
/* 43 */       if (block instanceof IHasModel)
/*    */       {
/* 45 */         ((IHasModel)block).registerModels();
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void preInitRegistries() {
/* 53 */     ToolMaterialsInit.registerToolMaterials();
/* 54 */     CreativeTabsInit.registerCreativetabs();
/* 55 */     EntityInit.registerEntity();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void initRegistries() {
/* 60 */     RecipesInit.registerRecipes();
/* 61 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenOres(), 0);
/* 62 */     MinecraftForge.EVENT_BUS.register(new EventHandler());
/* 63 */     NetworkInit.registerNetwork();
/*    */   }
/*    */   
/*    */   public static void postInitRegistries() {}
/*    */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literi\\utils\handlers\RegistryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */