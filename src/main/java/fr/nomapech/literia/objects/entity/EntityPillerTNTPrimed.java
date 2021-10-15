package fr.nomapech.literia.objects.entity;

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
      this.preventEntitySpawning = true;
      this.isImmuneToFire = true;
      this.setSize(0.98F, 0.98F);
   }

   @Override
   protected void entityInit() {

   }

   @Override
   protected void readEntityFromNBT(NBTTagCompound compound) {

   }

   @Override
   protected void writeEntityToNBT(NBTTagCompound compound) {

   }

   public EntityPillerTNTPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
      this(worldIn);
      this.setPosition(x, y, z);
      float f = (float)(Math.random() * 6.283185307179586D);
      this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
      this.motionY = 0.20000000298023224D;
      this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
      this.setFuse(80);
      this.prevPosX = x;
      this.prevPosY = y;
      this.prevPosZ = z;
      this.tntPlacedBy = igniter;
   }

   protected void func_70088_a() {
      this.dataManager.register(FUSE, Integer.valueOf(80));
   }

   protected boolean func_70041_e_() {
      return false;
   }

   public boolean func_70067_L() {
      return !this.isDead;
   }

   public void func_70071_h_() {
      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      if (!this.hasNoGravity()) {
         this.motionY -= 0.03999999910593033D;
      }

      this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
      this.motionX *= 0.9800000190734863D;
      this.motionY *= 0.9800000190734863D;
      this.motionZ *= 0.9800000190734863D;
      if (this.onGround) {
         this.motionX *= 0.699999988079071D;
         this.motionZ *= 0.699999988079071D;
         this.motionY *= -0.5D;
      }

      --this.fuse;
      if (this.fuse <= 0) {
         this.setDead();
         if (!this.world.isRemote) {
            this.explode();
         }
      } else {
         this.handleWaterMovement();
         this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   private void explode() {
      float explodeIntensity = 4.0F;
      this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, explodeIntensity, true);
   }

   protected void func_70014_b(NBTTagCompound compound) {
      compound.setShort("Fuse", (short)this.getFuse());
   }

   protected void func_70037_a(NBTTagCompound compound) {
      this.setFuse(compound.getShort("Fuse"));
   }

   @Nullable
   public EntityLivingBase getTntPlacedBy() {
      return this.tntPlacedBy;
   }

   public float func_70047_e() {
      return 0.0F;
   }

   public void setFuse(int fuseIn) {
      this.dataManager.set(FUSE, fuseIn);
      this.fuse = fuseIn;
   }

   public void func_184206_a(DataParameter key) {
      if (FUSE.equals(key)) {
         this.fuse = this.getFuseDataManager();
      }

   }

   public int getFuseDataManager() {
      return ((Integer)this.dataManager.get(FUSE)).intValue();
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
      return TextureMap.LOCATION_BLOCKS_TEXTURE;
   }

   static {
      FUSE = EntityDataManager.createKey(EntityPillerTNTPrimed.class, DataSerializers.VARINT);
   }
}
