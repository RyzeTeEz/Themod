/*    */ package fr.diskmth.literia.client.gui;
/*    */ 
/*    */ import fr.diskmth.literia.init.ItemsInit;
/*    */ import java.time.Duration;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiUnclaimFinder
/*    */   extends Gui
/*    */ {
/*    */   private static Minecraft mc;
/* 22 */   public static int amountTiles = 0;
/*    */   
/*    */   FontRenderer fontRender;
/* 25 */   final ResourceLocation UNCLAIM_FINDER_LVL_1 = new ResourceLocation("literiamod:textures/gui/unclaim_finder_lvl_1.png");
/* 26 */   final ResourceLocation UNCLAIM_FINDER_LVL_2 = new ResourceLocation("literiamod:textures/gui/unclaim_finder_lvl_2.png");
/*    */ 
/*    */   
/*    */   public GuiUnclaimFinder() {
/* 30 */     this; mc = Minecraft.func_71410_x();
/* 31 */     this; this.fontRender = mc.field_71466_p;
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onRenderPre(RenderGameOverlayEvent.Pre event) {
/* 37 */     if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET && mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() == ItemsInit.UNCLAIM_FINDER_LVL_1) {
/*    */ 
/*    */       
/* 40 */       amountTiles = mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj + 0).func_177434_r().values().size();
/*    */       
/* 42 */       mc.func_110434_K().func_110577_a(this.UNCLAIM_FINDER_LVL_1);
/* 43 */       func_146110_a(5, 5, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
/*    */       
/* 45 */       this; this; func_73732_a(mc.field_71466_p, amountTiles + "%", 23, 39, -1);
/* 46 */       this; this; func_73732_a(mc.field_71466_p, formatDuration(), 23, 48, -1);
/*    */       
/* 48 */       event.setCanceled(true);
/*    */     
/*    */     }
/* 51 */     else if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET && mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() == ItemsInit.UNCLAIM_FINDER_LVL_2) {
/*    */ 
/*    */       
/* 54 */       amountTiles = mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj + 0).func_177434_r().values().size();
/*    */       
/* 56 */       amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj + 1)
/* 57 */         .func_177434_r().values().size();
/*    */       
/* 59 */       amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj - 1)
/* 60 */         .func_177434_r().values().size();
/*    */       
/* 62 */       amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 1, mc.field_71439_g.field_70164_aj)
/* 63 */         .func_177434_r().values().size();
/*    */       
/* 65 */       amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah - 1, mc.field_71439_g.field_70164_aj)
/* 66 */         .func_177434_r().values().size();
/*    */       
/* 68 */       mc.func_110434_K().func_110577_a(this.UNCLAIM_FINDER_LVL_2);
/* 69 */       func_146110_a(5, 5, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
/*    */       
/* 71 */       this; this; func_73732_a(mc.field_71466_p, amountTiles + "%", 23, 39, -1);
/* 72 */       this; this; func_73732_a(mc.field_71466_p, formatDuration(), 23, 48, -1);
/*    */       
/* 74 */       event.setCanceled(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static String formatDuration() {
/* 80 */     ItemStack stack = mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND);
/*    */     
/* 82 */     int maxD = stack.func_77958_k();
/* 83 */     int itemD = stack.func_77952_i();
/*    */     
/* 85 */     int damage = maxD - itemD;
/*    */     
/* 87 */     Duration duration = Duration.ofSeconds((damage / 20));
/* 88 */     long seconds = duration.getSeconds();
/* 89 */     long absSeconds = Math.abs(seconds);
/* 90 */     String positive = String.format("%d:%02d:%02d", new Object[] {
/*    */           
/* 92 */           Long.valueOf(absSeconds / 3600L), 
/* 93 */           Long.valueOf(absSeconds % 3600L / 60L), 
/* 94 */           Long.valueOf(absSeconds % 60L) });
/* 95 */     return (seconds < 0L) ? ("-" + positive) : positive;
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\client\gui\GuiUnclaimFinder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */