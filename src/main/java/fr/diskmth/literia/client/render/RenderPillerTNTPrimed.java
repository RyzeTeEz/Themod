package fr.diskmth.literia.client.render;

import fr.diskmth.literia.init.BlocksInit;
import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPillerTNTPrimed extends Render {
   public RenderPillerTNTPrimed(RenderManager renderManagerIn) {
      super(renderManagerIn);
      this.field_76989_e = 0.5F;
   }

   public void doRender(EntityPillerTNTPrimed entity, double x, double y, double z, float entityYaw, float partialTicks) {
      BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)x, (float)y + 0.5F, (float)z);
      float f2;
      if ((float)entity.getFuse() - partialTicks + 1.0F < 10.0F) {
         f2 = 1.0F - ((float)entity.getFuse() - partialTicks + 1.0F) / 10.0F;
         f2 = MathHelper.func_76131_a(f2, 0.0F, 1.0F);
         f2 *= f2;
         f2 *= f2;
         float f1 = 1.0F + f2 * 0.3F;
         GlStateManager.func_179152_a(f1, f1, f1);
      }

      f2 = (1.0F - ((float)entity.getFuse() - partialTicks + 1.0F) / 100.0F) * 0.8F;
      this.func_180548_c(entity);
      GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179109_b(-0.5F, -0.5F, 0.5F);
      blockrendererdispatcher.func_175016_a(BlocksInit.PILLER_TNT.func_176223_P(), entity.func_70013_c());
      GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
      if (this.field_188301_f) {
         GlStateManager.func_179142_g();
         GlStateManager.func_187431_e(this.func_188298_c(entity));
         blockrendererdispatcher.func_175016_a(BlocksInit.PILLER_TNT.func_176223_P(), 1.0F);
         GlStateManager.func_187417_n();
         GlStateManager.func_179119_h();
      } else if (entity.getFuse() / 5 % 2 == 0) {
         GlStateManager.func_179090_x();
         GlStateManager.func_179140_f();
         GlStateManager.func_179147_l();
         GlStateManager.func_187401_a(SourceFactor.SRC_ALPHA, DestFactor.DST_ALPHA);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, f2);
         GlStateManager.func_179136_a(-3.0F, -3.0F);
         GlStateManager.func_179088_q();
         blockrendererdispatcher.func_175016_a(BlocksInit.PILLER_TNT.func_176223_P(), 1.0F);
         GlStateManager.func_179136_a(0.0F, 0.0F);
         GlStateManager.func_179113_r();
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179084_k();
         GlStateManager.func_179145_e();
         GlStateManager.func_179098_w();
      }

      GlStateManager.func_179121_F();
      super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
   }

   protected ResourceLocation getEntityTexture(EntityPillerTNTPrimed entity) {
      return TextureMap.field_110575_b;
   }

   public static class RenderFactory implements IRenderFactory {
      public Render createRenderFor(RenderManager manager) {
         return new RenderPillerTNTPrimed(manager);
      }
   }
}
