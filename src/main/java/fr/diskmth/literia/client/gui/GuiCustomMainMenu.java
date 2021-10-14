package fr.diskmth.literia.client.gui;

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

   public boolean func_73868_f() {
      return false;
   }

   public void func_73866_w_() {
      this.viewportTexture = new DynamicTexture(256, 256);
      this.backgroundTexture = this.field_146297_k.func_110434_K().func_110578_a("background", this.viewportTexture);
      this.widthCopyright = this.field_146289_q.func_78256_a("Literia n'est en aucun cas affilie a Mojang AB ");
      this.widthCopyrightRest = this.field_146294_l - this.widthCopyright - 2;
      int j = this.field_146295_m / 4 + 48;
      this.addPlayButton(j, 24);
      this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, j + 72 + 12, 98, 20, I18n.func_135052_a("menu.options", new Object[0])));
      this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 + 2, j + 72 + 12, 98, 20, I18n.func_135052_a("menu.quit", new Object[0])));
   }

   private void addPlayButton(int p_73969_1_, int p_73969_2_) {
      this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, p_73969_1_ + p_73969_2_ * 1, I18n.func_135052_a("menu.play", new Object[0])));
   }

   protected void func_146284_a(GuiButton button) throws IOException {
      if (button.field_146127_k == 0) {
         this.field_146297_k.func_147108_a(new GuiOptions(this, this.field_146297_k.field_71474_y));
      }

      if (button.field_146127_k == 2) {
         FMLClientHandler.instance().connectToServer(this, new ServerData("literia", "literia.ouimc.fr:25565", false));
      }

      if (button.field_146127_k == 4) {
         this.field_146297_k.func_71400_g();
      }

   }

   private void drawPanorama(int mouseX, int mouseY, float partialTicks) {
      Tessellator tessellator = Tessellator.func_178181_a();
      BufferBuilder bufferbuilder = tessellator.func_178180_c();
      GlStateManager.func_179128_n(5889);
      GlStateManager.func_179094_E();
      GlStateManager.func_179096_D();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GlStateManager.func_179128_n(5888);
      GlStateManager.func_179094_E();
      GlStateManager.func_179096_D();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179114_b(180.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179147_l();
      GlStateManager.func_179118_c();
      GlStateManager.func_179129_p();
      GlStateManager.func_179132_a(false);
      GlStateManager.func_187428_a(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);

      for(int j = 0; j < 64; ++j) {
         GlStateManager.func_179094_E();
         float f = ((float)(j % 8) / 8.0F - 0.5F) / 64.0F;
         float f1 = ((float)(j / 8) / 8.0F - 0.5F) / 64.0F;
         GlStateManager.func_179109_b(f, f1, 0.0F);
         GlStateManager.func_179114_b(MathHelper.func_76126_a(this.panoramaTimer / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179114_b(-this.panoramaTimer * 0.1F, 0.0F, 1.0F, 0.0F);

         for(int k = 0; k < 6; ++k) {
            GlStateManager.func_179094_E();
            if (k == 1) {
               GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 2) {
               GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 3) {
               GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 4) {
               GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (k == 5) {
               GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            this.field_146297_k.func_110434_K().func_110577_a(TITLE_PANORAMA_PATHS[k]);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
            int l = 255 / (j + 1);
            bufferbuilder.func_181662_b(-1.0D, -1.0D, 1.0D).func_187315_a(0.0D, 0.0D).func_181669_b(255, 255, 255, l).func_181675_d();
            bufferbuilder.func_181662_b(1.0D, -1.0D, 1.0D).func_187315_a(1.0D, 0.0D).func_181669_b(255, 255, 255, l).func_181675_d();
            bufferbuilder.func_181662_b(1.0D, 1.0D, 1.0D).func_187315_a(1.0D, 1.0D).func_181669_b(255, 255, 255, l).func_181675_d();
            bufferbuilder.func_181662_b(-1.0D, 1.0D, 1.0D).func_187315_a(0.0D, 1.0D).func_181669_b(255, 255, 255, l).func_181675_d();
            tessellator.func_78381_a();
            GlStateManager.func_179121_F();
         }

         GlStateManager.func_179121_F();
         GlStateManager.func_179135_a(true, true, true, false);
      }

      bufferbuilder.func_178969_c(0.0D, 0.0D, 0.0D);
      GlStateManager.func_179135_a(true, true, true, true);
      GlStateManager.func_179128_n(5889);
      GlStateManager.func_179121_F();
      GlStateManager.func_179128_n(5888);
      GlStateManager.func_179121_F();
      GlStateManager.func_179132_a(true);
      GlStateManager.func_179089_o();
      GlStateManager.func_179126_j();
   }

   private void rotateAndBlurSkybox() {
      this.field_146297_k.func_110434_K().func_110577_a(this.backgroundTexture);
      GlStateManager.func_187421_b(3553, 10241, 9729);
      GlStateManager.func_187421_b(3553, 10240, 9729);
      GlStateManager.func_187443_a(3553, 0, 0, 0, 0, 0, 256, 256);
      GlStateManager.func_179147_l();
      GlStateManager.func_187428_a(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.func_179135_a(true, true, true, false);
      Tessellator tessellator = Tessellator.func_178181_a();
      BufferBuilder bufferbuilder = tessellator.func_178180_c();
      bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
      GlStateManager.func_179118_c();

      for(int j = 0; j < 3; ++j) {
         float f = 1.0F / (float)(j + 1);
         int k = this.field_146294_l;
         int l = this.field_146295_m;
         float f1 = (float)(j - 1) / 256.0F;
         bufferbuilder.func_181662_b((double)k, (double)l, (double)this.field_73735_i).func_187315_a((double)(0.0F + f1), 1.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
         bufferbuilder.func_181662_b((double)k, 0.0D, (double)this.field_73735_i).func_187315_a((double)(1.0F + f1), 1.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
         bufferbuilder.func_181662_b(0.0D, 0.0D, (double)this.field_73735_i).func_187315_a((double)(1.0F + f1), 0.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
         bufferbuilder.func_181662_b(0.0D, (double)l, (double)this.field_73735_i).func_187315_a((double)(0.0F + f1), 0.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
      }

      tessellator.func_78381_a();
      GlStateManager.func_179141_d();
      GlStateManager.func_179135_a(true, true, true, true);
   }

   private void renderSkybox(int mouseX, int mouseY, float partialTicks) {
      this.field_146297_k.func_147110_a().func_147609_e();
      GlStateManager.func_179083_b(0, 0, 256, 256);
      this.drawPanorama(mouseX, mouseY, partialTicks);
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.rotateAndBlurSkybox();
      this.field_146297_k.func_147110_a().func_147610_a(true);
      GlStateManager.func_179083_b(0, 0, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
      float f = 120.0F / (float)(this.field_146294_l > this.field_146295_m ? this.field_146294_l : this.field_146295_m);
      float f1 = (float)this.field_146295_m * f / 256.0F;
      float f2 = (float)this.field_146294_l * f / 256.0F;
      int i = this.field_146294_l;
      int j = this.field_146295_m;
      Tessellator tessellator = Tessellator.func_178181_a();
      BufferBuilder bufferbuilder = tessellator.func_178180_c();
      bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
      bufferbuilder.func_181662_b(0.0D, (double)j, (double)this.field_73735_i).func_187315_a((double)(0.5F - f1), (double)(0.5F + f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      bufferbuilder.func_181662_b((double)i, (double)j, (double)this.field_73735_i).func_187315_a((double)(0.5F - f1), (double)(0.5F - f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      bufferbuilder.func_181662_b((double)i, 0.0D, (double)this.field_73735_i).func_187315_a((double)(0.5F + f1), (double)(0.5F - f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      bufferbuilder.func_181662_b(0.0D, 0.0D, (double)this.field_73735_i).func_187315_a((double)(0.5F + f1), (double)(0.5F + f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
      tessellator.func_78381_a();
   }

   public void drawLogo() {
      this.field_146297_k.func_110434_K().func_110577_a(LOGO);
      Tessellator tess = Tessellator.func_178181_a();
      BufferBuilder bb = tess.func_178180_c();
      bb.func_181668_a(7, DefaultVertexFormats.field_181707_g);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      bb.func_181662_b((double)this.field_146294_l / 2.0D - (double)this.field_146294_l / 9.4D, 5.0D, (double)this.field_73735_i).func_187315_a(0.0D, 0.0D).func_181675_d();
      bb.func_181662_b((double)this.field_146294_l / 2.0D - (double)this.field_146294_l / 9.4D, (double)this.field_146295_m / 2.0D - (double)this.field_146295_m / 8.7D, (double)this.field_73735_i).func_187315_a(0.0D, 1.0D).func_181675_d();
      bb.func_181662_b((double)this.field_146294_l / 2.0D + (double)this.field_146294_l / 9.4D, (double)this.field_146295_m / 2.0D - (double)this.field_146295_m / 8.7D, (double)this.field_73735_i).func_187315_a(1.0D, 1.0D).func_181675_d();
      bb.func_181662_b((double)this.field_146294_l / 2.0D + (double)this.field_146294_l / 9.4D, 5.0D, (double)this.field_73735_i).func_187315_a(1.0D, 0.0D).func_181675_d();
      tess.func_78381_a();
   }

   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
      this.panoramaTimer += partialTicks;
      GlStateManager.func_179118_c();
      this.renderSkybox(mouseX, mouseY, partialTicks);
      GlStateManager.func_179141_d();
      this.func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, -2130706433, 16777215);
      this.func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, 0, Integer.MIN_VALUE);
      this.drawLogo();
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)(this.field_146294_l / 2 + 90), 70.0F, 0.0F);
      GlStateManager.func_179114_b(-20.0F, 0.0F, 0.0F, 1.0F);
      float f = 1.8F - MathHelper.func_76135_e(MathHelper.func_76126_a((float)(Minecraft.func_71386_F() % 1000L) / 1000.0F * 6.2831855F) * 0.1F);
      f = f * 100.0F / (float)(this.field_146289_q.func_78256_a(this.splashText) + 32);
      GlStateManager.func_179152_a(f, f, f);
      this.func_73732_a(this.field_146289_q, this.splashText, 0, -8, -256);
      GlStateManager.func_179121_F();
      this.func_73731_b(this.field_146289_q, "Literia n'est en aucun cas affilie a Mojang AB", this.widthCopyrightRest, this.field_146295_m - 10, -1);
      super.func_73863_a(mouseX, mouseY, partialTicks);
   }
}
