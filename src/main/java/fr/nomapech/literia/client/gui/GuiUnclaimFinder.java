package fr.nomapech.literia.client.gui;

import fr.nomapech.literia.init.ItemsInit;
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
      this.fontRender = mc.fontRenderer;
   }

   @SubscribeEvent
   public void onRenderPre(Pre event) {
      if (event.getType() == ElementType.HELMET && mc.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ItemsInit.UNCLAIM_FINDER_LVL_1) {
         amountTiles = mc.world.getChunk(mc.player.chunkCoordX + 0, mc.player.chunkCoordZ + 0).getTileEntityMap().values().size();
         mc.getTextureManager().bindTexture(this.UNCLAIM_FINDER_LVL_1);
         drawModalRectWithCustomSizedTexture(5, 5, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
         this.drawCenteredString(mc.fontRenderer, amountTiles + "%", 23, 39, -1);
         this.drawCenteredString(mc.fontRenderer, formatDuration(), 23, 48, -1);
         event.setCanceled(true);
      } else if (event.getType() == ElementType.HELMET && mc.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ItemsInit.UNCLAIM_FINDER_LVL_2) {
         amountTiles = mc.world.getChunk(mc.player.chunkCoordX + 0, mc.player.chunkCoordZ + 0).getTileEntityMap().values().size();
         amountTiles += mc.world.getChunk(mc.player.chunkCoordX + 0, mc.player.chunkCoordZ + 1).getTileEntityMap().values().size();
         amountTiles += mc.world.getChunk(mc.player.chunkCoordX + 0, mc.player.chunkCoordZ - 1).getTileEntityMap().values().size();
         amountTiles += mc.world.getChunk(mc.player.chunkCoordX + 1, mc.player.chunkCoordZ).getTileEntityMap().values().size();
         amountTiles += mc.world.getChunk(mc.player.chunkCoordX - 1, mc.player.chunkCoordZ).getTileEntityMap().values().size();
         mc.getTextureManager().bindTexture(this.UNCLAIM_FINDER_LVL_2);
         drawModalRectWithCustomSizedTexture(5, 5, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
         this.drawCenteredString(mc.fontRenderer, amountTiles + "%", 23, 39, -1);
         this.drawCenteredString(mc.fontRenderer, formatDuration(), 23, 48, -1);
         event.setCanceled(true);
      }

   }

   public static String formatDuration() {
      ItemStack stack = mc.player.getHeldItem(EnumHand.MAIN_HAND);
      int maxD = stack.getMaxDamage();
      int itemD = stack.getItemDamage();
      int damage = maxD - itemD;
      Duration duration = Duration.ofSeconds((long)(damage / 20));
      long seconds = duration.getSeconds();
      long absSeconds = Math.abs(seconds);
      String positive = String.format("%d:%02d:%02d", absSeconds / 3600L, absSeconds % 3600L / 60L, absSeconds % 60L);
      return seconds < 0L ? "-" + positive : positive;
   }
}
