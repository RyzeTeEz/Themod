package fr.diskmth.literia.objects.entity;

import io.netty.buffer.ByteBuf;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityPillerTNTPrimed extends Entity implements IEntityAdditionalSpawnData {
   private static final DataParameter FUSE;
   @Nullable
   private EntityLivingBase tntPlacedBy;
   private int fuse;

   public EntityPillerTNTPrimed(World worldIn) {
      super(worldIn);
      this.fuse = 80;
      this.field_70156_m = true;
      this.field_70178_ae = true;
      this.func_70105_a(0.98F, 0.98F);
   }

   public EntityPillerTNTPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
      this(worldIn);
      this.func_70107_b(x, y, z);
      float f = (float)(Math.random() * 6.283185307179586D);
      this.field_70159_w = (double)(-((float)Math.sin((double)f)) * 0.02F);
      this.field_70181_x = 0.20000000298023224D;
      this.field_70179_y = (double)(-((float)Math.cos((double)f)) * 0.02F);
      this.setFuse(80);
      this.field_70169_q = x;
      this.field_70167_r = y;
      this.field_70166_s = z;
      this.tntPlacedBy = igniter;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_187214_a(FUSE, Integer.valueOf(80));
   }

   protected boolean func_70041_e_() {
      return false;
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if (!this.func_189652_ae()) {
         this.field_70181_x -= 0.03999999910593033D;
      }

      this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9800000190734863D;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= 0.9800000190734863D;
      if (this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
         this.field_70181_x *= -0.5D;
      }

      --this.fuse;
      if (this.fuse <= 0) {
         this.func_70106_y();
         if (!this.field_70170_p.field_72995_K) {
            this.explode();
         }
      } else {
         this.func_70072_I();
         this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   private void explode() {
      float explodeIntensity = 4.0F;
      this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 16.0F), this.field_70161_v, explodeIntensity, true);
   }

   protected void func_70014_b(NBTTagCompound compound) {
      compound.func_74777_a("Fuse", (short)this.getFuse());
   }

   protected void func_70037_a(NBTTagCompound compound) {
      this.setFuse(compound.func_74765_d("Fuse"));
   }

   @Nullable
   public EntityLivingBase getTntPlacedBy() {
      return this.tntPlacedBy;
   }

   public float func_70047_e() {
      return 0.0F;
   }

   public void setFuse(int fuseIn) {
      this.field_70180_af.func_187227_b(FUSE, fuseIn);
      this.fuse = fuseIn;
   }

   public void func_184206_a(DataParameter key) {
      if (FUSE.equals(key)) {
         this.fuse = this.getFuseDataManager();
      }

   }

   public int getFuseDataManager() {
      return ((Integer)this.field_70180_af.func_187225_a(FUSE)).intValue();
   }

   public int getFuse() {
      return this.fuse;
   }

   public void writeSpawnData(ByteBuf buffer) {
      buffer.writeInt(this.fuse);
   }

   public void readSpawnData(ByteBuf additionalData) {
      this.fuse = additionalData.readInt();
   }

   protected ResourceLocation getEntityTexture(EntityPillerTNTPrimed entity) {
      return TextureMap.field_110575_b;
   }

   static {
      FUSE = EntityDataManager.func_187226_a(EntityPillerTNTPrimed.class, DataSerializers.field_187192_b);
   }
}
