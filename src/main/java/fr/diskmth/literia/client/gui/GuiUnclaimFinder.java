package fr.diskmth.literia.client.gui;

import fr.diskmth.literia.init.ItemsInit;
import java.time.Duration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiUnclaimFinder extends Gui {
   private static Minecraft mc;
   public static int amountTiles = 0;
   FontRenderer fontRender;
   final ResourceLocation UNCLAIM_FINDER_LVL_1 = new ResourceLocation("literiamod:textures/gui/unclaim_finder_lvl_1.png");
   final ResourceLocation UNCLAIM_FINDER_LVL_2 = new ResourceLocation("literiamod:textures/gui/unclaim_finder_lvl_2.png");

   public GuiUnclaimFinder() {
      mc = Minecraft.getMinecraft();
      this.fontRender = mc.field_71466_p;
   }

   @SubscribeEvent
   public void onRenderPre(Pre event) {
      if (event.getType() == ElementType.HELMET && mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() == ItemsInit.UNCLAIM_FINDER_LVL_1) {
         amountTiles = mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj + 0).func_177434_r().values().size();
         mc.func_110434_K().func_110577_a(this.UNCLAIM_FINDER_LVL_1);
         func_146110_a(5, 5, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
         this.func_73732_a(mc.field_71466_p, amountTiles + "%", 23, 39, -1);
         this.func_73732_a(mc.field_71466_p, formatDuration(), 23, 48, -1);
         event.setCanceled(true);
      } else if (event.getType() == ElementType.HELMET && mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() == ItemsInit.UNCLAIM_FINDER_LVL_2) {
         amountTiles = mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj + 0).func_177434_r().values().size();
         amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj + 1).func_177434_r().values().size();
         amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 0, mc.field_71439_g.field_70164_aj - 1).func_177434_r().values().size();
         amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah + 1, mc.field_71439_g.field_70164_aj).func_177434_r().values().size();
         amountTiles += mc.field_71441_e.func_72964_e(mc.field_71439_g.field_70176_ah - 1, mc.field_71439_g.field_70164_aj).func_177434_r().values().size();
         mc.func_110434_K().func_110577_a(this.UNCLAIM_FINDER_LVL_2);
         func_146110_a(5, 5, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
         this.func_73732_a(mc.field_71466_p, amountTiles + "%", 23, 39, -1);
         this.func_73732_a(mc.field_71466_p, formatDuration(), 23, 48, -1);
         event.setCanceled(true);
      }

   }

   public static String formatDuration() {
      ItemStack stack = mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND);
      int maxD = stack.func_77958_k();
      int itemD = stack.func_77952_i();
      int damage = maxD - itemD;
      Duration duration = Duration.ofSeconds((long)(damage / 20));
      long seconds = duration.getSeconds();
      long absSeconds = Math.abs(seconds);
      String positive = String.format("%d:%02d:%02d", absSeconds / 3600L, absSeconds % 3600L / 60L, absSeconds % 60L);
      return seconds < 0L ? "-" + positive : positive;
   }
}
