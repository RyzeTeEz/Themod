package fr.nomapech.literia.client.gui;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

@SideOnly(Side.CLIENT)
public class GuiCustomMainMenu extends GuiScreen {
   private static final Random RANDOM = new Random();
   private String splashText = "missingno";
   private float panoramaTimer;
   private DynamicTexture viewportTexture;
   private static final ResourceLocation SPLASH_TEXTS = new ResourceLocation("literiamod:textures/gui/main_menu/splash.txt");
   private static final ResourceLocation LOGO = new ResourceLocation("literiamod:textures/logo/logo.png");
   private static final ResourceLocation[] TITLE_PANORAMA_PATHS = new ResourceLocation[]{new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_0.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_1.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_2.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_3.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_4.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_5.png")};
   private ResourceLocation backgroundTexture;
   private int widthCopyright;
   private int widthCopyrightRest;

   public GuiCustomMainMenu() {
      IResource iresource = null;

      try {
         List list = Lists.newArrayList();
         iresource = Minecraft.getMinecraft().getResourceManager().getResource(SPLASH_TEXTS);
         BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(iresource.getInputStream(), StandardCharsets.UTF_8));

         String s;
         while((s = bufferedreader.readLine()) != null) {
            s = s.trim();
            if (!s.isEmpty()) {
               list.add(s);
            }
         }

         if (!list.isEmpty()) {
            do {
               this.splashText = (String)list.get(RANDOM.nextInt(list.size()));
            } while(this.splashText.hashCode() == 125780783);
         }
      } catch (IOException var8) {
         ;
      } finally {
         IOUtils.closeQuietly(iresource);
      }

      FMLClientHandler.instance().setupServerList();
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void func_73866_w_() {
      this.viewportTexture = new DynamicTexture(256, 256);
      this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
      this.widthCopyright = this.fontRenderer.getStringWidth("Literia n'est en aucun cas affilie a Mojang AB ");
      this.widthCopyrightRest = this.width - this.widthCopyright - 2;
      int j = this.height / 4 + 48;
      this.addPlayButton(j, 24);
      this.	buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options")));
      this.	buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit")));
   }

   private void addPlayButton(int p_73969_1_, int p_73969_2_) {
      this.	buttonList.add(new GuiButton(2, this.width / 2 - 100, p_73969_1_ + p_73969_2_ * 1, I18n.format("menu.play")));
   }

   protected void actionPerformed(GuiButton button) throws IOException {
      if (button.id == 0) {
         this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
      }

      if (button.id == 2) {
         FMLClientHandler.instance().connectToServer(this, new ServerData("literia", "literia.ouimc.fr:25565", false));
      }

      if (button.id == 4) {
         this.mc.shutdown();
      }

   }

   private void drawPanorama(int mouseX, int mouseY, float partialTicks) {
      Tessellator tessellator = Tessellator.getInstance();
      BufferBuilder bufferbuilder = tessellator.getBuffer();
      GlStateManager.matrixMode(5889);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);

      for(int j = 0; j < 64; ++j) {
         GlStateManager.pushMatrix();
         float f = ((float)(j % 8) / 8.0F - 0.5F) / 64.0F;
         float f1 = ((float)(j / 8) / 8.0F - 0.5F) / 64.0F;
         GlStateManager.translate(f, f1, 0.0F);
         GlStateManager.rotate(MathHelper.sin(this.panoramaTimer / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate(-this.panoramaTimer * 0.1F, 0.0F, 1.0F, 0.0F);

         for(int k = 0; k < 6; ++k) {
            GlStateManager.pushMatrix();
            if (k == 1) {
               GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 2) {
               GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 3) {
               GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 4) {
               GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (k == 5) {
               GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            this.mc.getTextureManager().bindTexture(TITLE_PANORAMA_PATHS[k]);
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            int l = 255 / (j + 1);
            bufferbuilder.pos(-1.0D, -1.0D, 1.0D).tex(0.0D, 0.0D).color(255, 255, 255, l).endVertex();
            bufferbuilder.pos(1.0D, -1.0D, 1.0D).tex(1.0D, 0.0D).color(255, 255, 255, l).endVertex();
            bufferbuilder.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, l).endVertex();
            bufferbuilder.pos(-1.0D, 1.0D, 1.0D).tex(0.0D, 1.0D).color(255, 255, 255, l).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
         }

         GlStateManager.popMatrix();
         GlStateManager.colorMask(true, true, true, false);
      }

      bufferbuilder.setTranslation(0.0D, 0.0D, 0.0D);
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableCull();
      GlStateManager.enableDepth();
   }

   private void rotateAndBlurSkybox() {
      this.mc.getTextureManager().bindTexture(this.backgroundTexture);
      GlStateManager.glTexParameteri(3553, 10241, 9729);
      GlStateManager.glTexParameteri(3553, 10240, 9729);
      GlStateManager.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.colorMask(true, true, true, false);
      Tessellator tessellator = Tessellator.getInstance();
      BufferBuilder bufferbuilder = tessellator.getBuffer();
      bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      GlStateManager.disableAlpha();

      for(int j = 0; j < 3; ++j) {
         float f = 1.0F / (float)(j + 1);
         int k = this.width;
         int l = this.height;
         float f1 = (float)(j - 1) / 256.0F;
         bufferbuilder.pos((double)k, (double)l, (double)this.zLevel).tex((double)(0.0F + f1), 1.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
         bufferbuilder.pos((double)k, 0.0D, (double)this.zLevel).tex((double)(1.0F + f1), 1.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
         bufferbuilder.pos(0.0D, 0.0D, (double)this.zLevel).tex((double)(1.0F + f1), 0.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
         bufferbuilder.pos(0.0D, (double)l, (double)this.zLevel).tex((double)(0.0F + f1), 0.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
      }

      tessellator.draw();
      GlStateManager.enableAlpha();
      GlStateManager.colorMask(true, true, true, true);
   }

   private void renderSkybox(int mouseX, int mouseY, float partialTicks) {
      this.mc.getFramebuffer().unbindFramebuffer();
      GlStateManager.viewport(0, 0, 256, 256);
      this.drawPanorama(mouseX, mouseY, partialTicks);
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.mc.getFramebuffer().bindFramebuffer(true);
      GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
      float f = 120.0F / (float)(this.width > this.height ? this.width : this.height);
      float f1 = (float)this.height * f / 256.0F;
      float f2 = (float)this.width * f / 256.0F;
      int i = this.width;
      int j = this.height;
      Tessellator tessellator = Tessellator.getInstance();
      BufferBuilder bufferbuilder = tessellator.getBuffer();
      bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      bufferbuilder.pos(0.0D, (double)j, (double)this.zLevel).tex((double)(0.5F - f1), (double)(0.5F + f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      bufferbuilder.pos((double)i, (double)j, (double)this.zLevel).tex((double)(0.5F - f1), (double)(0.5F - f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      bufferbuilder.pos((double)i, 0.0D, (double)this.zLevel).tex((double)(0.5F + f1), (double)(0.5F - f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      bufferbuilder.pos(0.0D, 0.0D, (double)this.zLevel).tex((double)(0.5F + f1), (double)(0.5F + f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      tessellator.draw();
   }

   public void drawLogo() {
      this.mc.getTextureManager().bindTexture(LOGO);
      Tessellator tess = Tessellator.getInstance();
      BufferBuilder bb = tess.getBuffer();
      bb.begin(7, DefaultVertexFormats.POSITION_TEX);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      bb.pos((double)this.width / 2.0D - (double)this.width / 9.4D, 5.0D, (double)this.zLevel).tex(0.0D, 0.0D).endVertex();
      bb.pos((double)this.width / 2.0D - (double)this.width / 9.4D, (double)this.height / 2.0D - (double)this.height / 8.7D, (double)this.zLevel).tex(0.0D, 1.0D).endVertex();
      bb.pos((double)this.width / 2.0D + (double)this.width / 9.4D, (double)this.height / 2.0D - (double)this.height / 8.7D, (double)this.zLevel).tex(1.0D, 1.0D).endVertex();
      bb.pos((double)this.width / 2.0D + (double)this.width / 9.4D, 5.0D, (double)this.zLevel).tex(1.0D, 0.0D).endVertex();
      tess.draw();
   }

   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
      this.panoramaTimer += partialTicks;
      GlStateManager.disableAlpha();
      this.renderSkybox(mouseX, mouseY, partialTicks);
      GlStateManager.enableAlpha();
      this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
      this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
      this.drawLogo();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)(this.width / 2 + 90), 70.0F, 0.0F);
      GlStateManager.rotate(-20.0F, 0.0F, 0.0F, 1.0F);
      float f = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * 6.2831855F) * 0.1F);
      f = f * 100.0F / (float)(this.fontRenderer.getStringWidth(this.splashText) + 32);
      GlStateManager.scale(f, f, f);
      this.drawCenteredString(this.fontRenderer, this.splashText, 0, -8, -256);
      GlStateManager.popMatrix();
      this.drawString(this.fontRenderer, "Literia n'est en aucun cas affilie a Mojang AB", this.widthCopyrightRest, this.height - 10, -1);
      super.drawScreen(mouseX, mouseY, partialTicks);
   }
}
