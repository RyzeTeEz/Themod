/*     */ package fr.diskmth.literia;
/*     */ 
/*     */ import fr.diskmth.literia.client.gui.GuiUnclaimFinder;
/*     */ import fr.diskmth.literia.init.RendersInit;
/*     */ import fr.diskmth.literia.utils.handlers.RegistryHandler;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.client.model.ModelLoader;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*     */ import net.minecraftforge.fml.common.SidedProxy;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod(modid = "literiamod", name = "Mod Literia", version = "1.0")
/*     */ public class Main
/*     */ {
/*     */   @SidedProxy(clientSide = "fr.diskmth.literia.Main$ClientProxy", serverSide = "fr.diskmth.literia.Main$CommonProxy")
/*     */   public static CommonProxy proxy;
/*     */   public static Logger logger;
/*     */   
/*     */   @EventHandler
/*     */   public static void preInit(FMLPreInitializationEvent e) throws Exception {
/*  31 */     if (e.getSide().isClient())
/*     */     {
/*  33 */       if (!(Minecraft.func_71410_x()).field_71412_D.getPath().contains(".Literia"));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  39 */     logger = e.getModLog();
/*  40 */     proxy.preInit();
/*  41 */     proxy.init();
/*  42 */     RegistryHandler.preInitRegistries();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public static void init(FMLInitializationEvent e) {
/*  48 */     RegistryHandler.initRegistries();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public static void postInit(FMLPostInitializationEvent e) {
/*  54 */     RegistryHandler.postInitRegistries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CommonProxy
/*     */   {
/*     */     public void registerItemRenderer(Item item, int meta) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void registerEntityRenderers() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void preInit() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void init() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ClientProxy
/*     */     extends CommonProxy
/*     */   {
/*     */     public void registerItemRenderer(Item item, int meta) {
/*  90 */       ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void registerVariantRenderer(Item item, int meta, String filename, String id) {
/*  96 */       super.registerVariantRenderer(item, meta, filename, id);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void registerEntityRenderers() {
/* 102 */       super.registerEntityRenderers();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void preInit() {
/* 108 */       super.preInit();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void init() {
/* 114 */       super.init();
/* 115 */       RendersInit.registerRenders();
/* 116 */       MinecraftForge.EVENT_BUS.register(new GuiUnclaimFinder());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */