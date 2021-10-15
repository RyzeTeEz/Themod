package fr.nomapech.literia.client.render;

import fr.nomapech.literia.init.BlocksInit;
import fr.nomapech.literia.objects.entity.EntityPillerTNTPrimed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderPillerTNTPrimed extends Render {
   public RenderPillerTNTPrimed(RenderManager renderManagerIn) {
      super(renderManagerIn);
      this.shadowSize = 0.5F;
   }

   @Nullable
   @Override
   protected ResourceLocation getEntityTexture(Entity entity) {
      return null;
   }

   public void doRender(EntityPillerTNTPrimed entity, double x, double y, double z, float entityYaw, float partialTicks) {
      BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)x, (float)y + 0.5F, (float)z);
      float f2;
      if ((float)entity.getFuse() - partialTicks + 1.0F < 10.0F) {
         f2 = 1.0F - ((float)entity.getFuse() - partialTicks + 1.0F) / 10.0F;
         f2 = MathHelper.clamp(f2, 0.0F, 1.0F);
         f2 *= f2;
         f2 *= f2;
         float f1 = 1.0F + f2 * 0.3F;
         GlStateManager.scale(f1, f1, f1);
      }

      f2 = (1.0F - ((float)entity.getFuse() - partialTicks + 1.0F) / 100.0F) * 0.8F;
      this.bindEntityTexture(entity);
      GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.translate(-0.5F, -0.5F, 0.5F);
      blockrendererdispatcher.renderBlockBrightness(BlocksInit.PILLER_TNT.getDefaultState(), entity.getBrightness());
      GlStateManager.translate(0.0F, 0.0F, 1.0F);
      if (this.renderOutlines) {
         GlStateManager.enableColorMaterial();
         GlStateManager.enableOutlineMode(this.getTeamColor(entity));
         blockrendererdispatcher.renderBlockBrightness(BlocksInit.PILLER_TNT.getDefaultState(), 1.0F);
         GlStateManager.disableOutlineMode();
         GlStateManager.disableColorMaterial();
      } else if (entity.getFuse() / 5 % 2 == 0) {
         GlStateManager.disableTexture2D();
         GlStateManager.disableLighting();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.DST_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, f2);
         GlStateManager.doPolygonOffset(-3.0F, -3.0F);
         GlStateManager.enablePolygonOffset();
         blockrendererdispatcher.renderBlockBrightness(BlocksInit.PILLER_TNT.getDefaultState(), 1.0F);
         GlStateManager.doPolygonOffset(0.0F, 0.0F);
         GlStateManager.disablePolygonOffset();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableBlend();
         GlStateManager.enableLighting();
         GlStateManager.enableTexture2D();
      }

      GlStateManager.popMatrix();
      super.doRender(entity, x, y, z, entityYaw, partialTicks);
   }

   protected ResourceLocation getEntityTexture(EntityPillerTNTPrimed entity) {
      return TextureMap.LOCATION_BLOCKS_TEXTURE;
   }

   public static class RenderFactory implements IRenderFactory {
      public Render createRenderFor(RenderManager manager) {
         return new RenderPillerTNTPrimed(manager);
      }
   }
}
