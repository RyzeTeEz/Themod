/*     */ package fr.diskmth.literia.client.gui;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiOptions;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraftforge.fml.client.FMLClientHandler;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.Project;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiCustomMainMenu
/*     */   extends GuiScreen
/*     */ {
/*  39 */   private static final Random RANDOM = new Random();
/*     */ 
/*     */ 
/*     */   
/*  43 */   private static final ResourceLocation SPLASH_TEXTS = new ResourceLocation("literiamod:textures/gui/main_menu/splash.txt");
/*  44 */   private static final ResourceLocation LOGO = new ResourceLocation("literiamod:textures/logo/logo.png");
/*  45 */   private static final ResourceLocation[] TITLE_PANORAMA_PATHS = new ResourceLocation[] { new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_0.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_1.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_2.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_3.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_4.png"), new ResourceLocation("literiamod:textures/gui/main_menu/background/panorama_5.png") };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private String splashText = "missingno"; private float panoramaTimer; private DynamicTexture viewportTexture; public GuiCustomMainMenu() {
/*  53 */     IResource iresource = null;
/*     */ 
/*     */     
/*     */     try {
/*  57 */       List<String> list = Lists.newArrayList();
/*  58 */       iresource = Minecraft.func_71410_x().func_110442_L().func_110536_a(SPLASH_TEXTS);
/*  59 */       BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(iresource.func_110527_b(), StandardCharsets.UTF_8));
/*     */       
/*     */       String s;
/*  62 */       while ((s = bufferedreader.readLine()) != null) {
/*     */         
/*  64 */         s = s.trim();
/*     */         
/*  66 */         if (!s.isEmpty())
/*     */         {
/*  68 */           list.add(s);
/*     */         }
/*     */       } 
/*     */       
/*  72 */       if (!list.isEmpty()) {
/*     */         do
/*     */         {
/*     */           
/*  76 */           this.splashText = list.get(RANDOM.nextInt(list.size()));
/*     */         }
/*  78 */         while (this.splashText.hashCode() == 125780783);
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*  85 */     catch (IOException iOException) {
/*     */ 
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/*  91 */       IOUtils.closeQuietly((Closeable)iresource);
/*     */     } 
/*     */     
/*  94 */     FMLClientHandler.instance().setupServerList();
/*     */   }
/*     */   private ResourceLocation backgroundTexture; private int widthCopyright; private int widthCopyrightRest;
/*     */   
/*     */   public boolean func_73868_f() {
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 104 */     this.viewportTexture = new DynamicTexture(256, 256);
/* 105 */     this.backgroundTexture = this.field_146297_k.func_110434_K().func_110578_a("background", this.viewportTexture);
/* 106 */     this.widthCopyright = this.field_146289_q.func_78256_a("Literia n'est en aucun cas affilie a Mojang AB ");
/* 107 */     this.widthCopyrightRest = this.field_146294_l - this.widthCopyright - 2;
/* 108 */     int j = this.field_146295_m / 4 + 48;
/* 109 */     addPlayButton(j, 24);
/* 110 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, j + 72 + 12, 98, 20, I18n.func_135052_a("menu.options", new Object[0])));
/* 111 */     this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 + 2, j + 72 + 12, 98, 20, I18n.func_135052_a("menu.quit", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   private void addPlayButton(int p_73969_1_, int p_73969_2_) {
/* 116 */     this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, p_73969_1_ + p_73969_2_ * 1, I18n.func_135052_a("menu.play", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton button) throws IOException {
/* 121 */     if (button.field_146127_k == 0)
/*     */     {
/* 123 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiOptions(this, this.field_146297_k.field_71474_y));
/*     */     }
/*     */     
/* 126 */     if (button.field_146127_k == 2)
/*     */     {
/* 128 */       FMLClientHandler.instance().connectToServer(this, new ServerData("literia", "literia.ouimc.fr:25565", false));
/*     */     }
/*     */     
/* 131 */     if (button.field_146127_k == 4)
/*     */     {
/* 133 */       this.field_146297_k.func_71400_g();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawPanorama(int mouseX, int mouseY, float partialTicks) {
/* 139 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 140 */     BufferBuilder bufferbuilder = tessellator.func_178180_c();
/* 141 */     GlStateManager.func_179128_n(5889);
/* 142 */     GlStateManager.func_179094_E();
/* 143 */     GlStateManager.func_179096_D();
/* 144 */     Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
/* 145 */     GlStateManager.func_179128_n(5888);
/* 146 */     GlStateManager.func_179094_E();
/* 147 */     GlStateManager.func_179096_D();
/* 148 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 149 */     GlStateManager.func_179114_b(180.0F, 1.0F, 0.0F, 0.0F);
/* 150 */     GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
/* 151 */     GlStateManager.func_179147_l();
/* 152 */     GlStateManager.func_179118_c();
/* 153 */     GlStateManager.func_179129_p();
/* 154 */     GlStateManager.func_179132_a(false);
/* 155 */     GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/*     */     
/* 157 */     for (int j = 0; j < 64; j++) {
/*     */       
/* 159 */       GlStateManager.func_179094_E();
/* 160 */       float f = ((j % 8) / 8.0F - 0.5F) / 64.0F;
/* 161 */       float f1 = ((j / 8) / 8.0F - 0.5F) / 64.0F;
/* 162 */       GlStateManager.func_179109_b(f, f1, 0.0F);
/* 163 */       GlStateManager.func_179114_b(MathHelper.func_76126_a(this.panoramaTimer / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
/* 164 */       GlStateManager.func_179114_b(-this.panoramaTimer * 0.1F, 0.0F, 1.0F, 0.0F);
/*     */       
/* 166 */       for (int k = 0; k < 6; k++) {
/*     */         
/* 168 */         GlStateManager.func_179094_E();
/*     */         
/* 170 */         if (k == 1)
/*     */         {
/* 172 */           GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 175 */         if (k == 2)
/*     */         {
/* 177 */           GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 180 */         if (k == 3)
/*     */         {
/* 182 */           GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 185 */         if (k == 4)
/*     */         {
/* 187 */           GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/*     */         }
/*     */         
/* 190 */         if (k == 5)
/*     */         {
/* 192 */           GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
/*     */         }
/*     */         
/* 195 */         this.field_146297_k.func_110434_K().func_110577_a(TITLE_PANORAMA_PATHS[k]);
/* 196 */         bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 197 */         int l = 255 / (j + 1);
/* 198 */         bufferbuilder.func_181662_b(-1.0D, -1.0D, 1.0D).func_187315_a(0.0D, 0.0D).func_181669_b(255, 255, 255, l).func_181675_d();
/* 199 */         bufferbuilder.func_181662_b(1.0D, -1.0D, 1.0D).func_187315_a(1.0D, 0.0D).func_181669_b(255, 255, 255, l).func_181675_d();
/* 200 */         bufferbuilder.func_181662_b(1.0D, 1.0D, 1.0D).func_187315_a(1.0D, 1.0D).func_181669_b(255, 255, 255, l).func_181675_d();
/* 201 */         bufferbuilder.func_181662_b(-1.0D, 1.0D, 1.0D).func_187315_a(0.0D, 1.0D).func_181669_b(255, 255, 255, l).func_181675_d();
/* 202 */         tessellator.func_78381_a();
/* 203 */         GlStateManager.func_179121_F();
/*     */       } 
/*     */       
/* 206 */       GlStateManager.func_179121_F();
/* 207 */       GlStateManager.func_179135_a(true, true, true, false);
/*     */     } 
/*     */     
/* 210 */     bufferbuilder.func_178969_c(0.0D, 0.0D, 0.0D);
/* 211 */     GlStateManager.func_179135_a(true, true, true, true);
/* 212 */     GlStateManager.func_179128_n(5889);
/* 213 */     GlStateManager.func_179121_F();
/* 214 */     GlStateManager.func_179128_n(5888);
/* 215 */     GlStateManager.func_179121_F();
/* 216 */     GlStateManager.func_179132_a(true);
/* 217 */     GlStateManager.func_179089_o();
/* 218 */     GlStateManager.func_179126_j();
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateAndBlurSkybox() {
/* 223 */     this.field_146297_k.func_110434_K().func_110577_a(this.backgroundTexture);
/* 224 */     GlStateManager.func_187421_b(3553, 10241, 9729);
/* 225 */     GlStateManager.func_187421_b(3553, 10240, 9729);
/* 226 */     GlStateManager.func_187443_a(3553, 0, 0, 0, 0, 0, 256, 256);
/* 227 */     GlStateManager.func_179147_l();
/* 228 */     GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/* 229 */     GlStateManager.func_179135_a(true, true, true, false);
/* 230 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 231 */     BufferBuilder bufferbuilder = tessellator.func_178180_c();
/* 232 */     bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 233 */     GlStateManager.func_179118_c();
/*     */     
/* 235 */     for (int j = 0; j < 3; j++) {
/*     */       
/* 237 */       float f = 1.0F / (j + 1);
/* 238 */       int k = this.field_146294_l;
/* 239 */       int l = this.field_146295_m;
/* 240 */       float f1 = (j - 1) / 256.0F;
/* 241 */       bufferbuilder.func_181662_b(k, l, this.field_73735_i).func_187315_a((0.0F + f1), 1.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
/* 242 */       bufferbuilder.func_181662_b(k, 0.0D, this.field_73735_i).func_187315_a((1.0F + f1), 1.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
/* 243 */       bufferbuilder.func_181662_b(0.0D, 0.0D, this.field_73735_i).func_187315_a((1.0F + f1), 0.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
/* 244 */       bufferbuilder.func_181662_b(0.0D, l, this.field_73735_i).func_187315_a((0.0F + f1), 0.0D).func_181666_a(1.0F, 1.0F, 1.0F, f).func_181675_d();
/*     */     } 
/*     */     
/* 247 */     tessellator.func_78381_a();
/* 248 */     GlStateManager.func_179141_d();
/* 249 */     GlStateManager.func_179135_a(true, true, true, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderSkybox(int mouseX, int mouseY, float partialTicks) {
/* 254 */     this.field_146297_k.func_147110_a().func_147609_e();
/* 255 */     GlStateManager.func_179083_b(0, 0, 256, 256);
/* 256 */     drawPanorama(mouseX, mouseY, partialTicks);
/* 257 */     rotateAndBlurSkybox();
/* 258 */     rotateAndBlurSkybox();
/* 259 */     rotateAndBlurSkybox();
/* 260 */     rotateAndBlurSkybox();
/* 261 */     rotateAndBlurSkybox();
/* 262 */     rotateAndBlurSkybox();
/* 263 */     rotateAndBlurSkybox();
/* 264 */     this.field_146297_k.func_147110_a().func_147610_a(true);
/* 265 */     GlStateManager.func_179083_b(0, 0, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 266 */     float f = 120.0F / ((this.field_146294_l > this.field_146295_m) ? this.field_146294_l : this.field_146295_m);
/* 267 */     float f1 = this.field_146295_m * f / 256.0F;
/* 268 */     float f2 = this.field_146294_l * f / 256.0F;
/* 269 */     int i = this.field_146294_l;
/* 270 */     int j = this.field_146295_m;
/* 271 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 272 */     BufferBuilder bufferbuilder = tessellator.func_178180_c();
/* 273 */     bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 274 */     bufferbuilder.func_181662_b(0.0D, j, this.field_73735_i).func_187315_a((0.5F - f1), (0.5F + f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
/* 275 */     bufferbuilder.func_181662_b(i, j, this.field_73735_i).func_187315_a((0.5F - f1), (0.5F - f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
/* 276 */     bufferbuilder.func_181662_b(i, 0.0D, this.field_73735_i).func_187315_a((0.5F + f1), (0.5F - f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
/* 277 */     bufferbuilder.func_181662_b(0.0D, 0.0D, this.field_73735_i).func_187315_a((0.5F + f1), (0.5F + f2)).func_181666_a(1.0F, 1.0F, 1.0F, 1.0F).func_181675_d();
/* 278 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawLogo() {
/* 283 */     this.field_146297_k.func_110434_K().func_110577_a(LOGO);
/*     */     
/* 285 */     Tessellator tess = Tessellator.func_178181_a();
/* 286 */     BufferBuilder bb = tess.func_178180_c();
/*     */     
/* 288 */     bb.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 289 */     GL11.glTexParameteri(3553, 10241, 9729);
/* 290 */     GL11.glTexParameteri(3553, 10240, 9729);
/*     */     
/* 292 */     bb.func_181662_b(this.field_146294_l / 2.0D - this.field_146294_l / 9.4D, 5.0D, this.field_73735_i).func_187315_a(0.0D, 0.0D).func_181675_d();
/* 293 */     bb.func_181662_b(this.field_146294_l / 2.0D - this.field_146294_l / 9.4D, this.field_146295_m / 2.0D - this.field_146295_m / 8.7D, this.field_73735_i).func_187315_a(0.0D, 1.0D).func_181675_d();
/* 294 */     bb.func_181662_b(this.field_146294_l / 2.0D + this.field_146294_l / 9.4D, this.field_146295_m / 2.0D - this.field_146295_m / 8.7D, this.field_73735_i).func_187315_a(1.0D, 1.0D).func_181675_d();
/* 295 */     bb.func_181662_b(this.field_146294_l / 2.0D + this.field_146294_l / 9.4D, 5.0D, this.field_73735_i).func_187315_a(1.0D, 0.0D).func_181675_d();
/* 296 */     tess.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 301 */     this.panoramaTimer += partialTicks;
/* 302 */     GlStateManager.func_179118_c();
/* 303 */     renderSkybox(mouseX, mouseY, partialTicks);
/* 304 */     GlStateManager.func_179141_d();
/* 305 */     func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, -2130706433, 16777215);
/* 306 */     func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, 0, -2147483648);
/* 307 */     drawLogo();
/* 308 */     GlStateManager.func_179094_E();
/* 309 */     GlStateManager.func_179109_b((this.field_146294_l / 2 + 90), 70.0F, 0.0F);
/* 310 */     GlStateManager.func_179114_b(-20.0F, 0.0F, 0.0F, 1.0F);
/* 311 */     float f = 1.8F - MathHelper.func_76135_e(MathHelper.func_76126_a((float)(Minecraft.func_71386_F() % 1000L) / 1000.0F * 6.2831855F) * 0.1F);
/* 312 */     f = f * 100.0F / (this.field_146289_q.func_78256_a(this.splashText) + 32);
/* 313 */     GlStateManager.func_179152_a(f, f, f);
/* 314 */     func_73732_a(this.field_146289_q, this.splashText, 0, -8, -256);
/* 315 */     GlStateManager.func_179121_F();
/* 316 */     func_73731_b(this.field_146289_q, "Literia n'est en aucun cas affilie a Mojang AB", this.widthCopyrightRest, this.field_146295_m - 10, -1);
/*     */     
/* 318 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\client\gui\GuiCustomMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */