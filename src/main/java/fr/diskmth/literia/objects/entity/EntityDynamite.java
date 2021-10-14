package fr.diskmth.literia.objects.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDynamite extends EntityThrowable {
   private static final DataParameter FUSE;
   private int fuse;

   public EntityDynamite(World worldIn) {
      super(worldIn);
      this.fuse = 40;
      this.field_70156_m = true;
      this.field_70178_ae = true;
   }

   public EntityDynamite(World worldIn, EntityLivingBase throwerIn) {
      super(worldIn, throwerIn);
      this.setFuse(40);
   }

   public EntityDynamite(World worldIn, double x, double y, double z) {
      super(worldIn, x, y, z);
   }

   public static void registerFixesEgg(DataFixer fixer) {
      EntityThrowable.func_189661_a(fixer, "ThrownDynamite");
   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte id) {
      if (id == 3) {
         double d0 = 0.08D;

         for(int i = 0; i < 8; ++i) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, this.field_70165_t, this.field_70163_u, this.field_70161_v, ((double)this.field_70146_Z.nextFloat() - 0.5D) * 0.08D, ((double)this.field_70146_Z.nextFloat() - 0.5D) * 0.08D, ((double)this.field_70146_Z.nextFloat() - 0.5D) * 0.08D, new int[]{Item.func_150891_b(Items.field_151110_aK)});
         }
      }

   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if (!this.func_189652_ae()) {
         this.field_70181_x -= 0.03999999910593033D;
      }

      this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9400000190734863D;
      this.field_70181_x *= 0.9400000190734863D;
      this.field_70179_y *= 0.9400000190734863D;
      if (this.field_70122_E) {
         this.field_70159_w *= 0.699999984079071D;
         this.field_70181_x *= 0.699999984079071D;
         this.field_70179_y *= -0.5D;
      }

      if (this.field_70122_E) {
         --this.fuse;
      }

      if (this.fuse <= 0) {
         this.func_70106_y();
         if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.5F, true);
         }
      } else {
         this.func_70072_I();
         this.field_70170_p.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   public void setFuse(int fuseIn) {
      this.field_70180_af.func_187227_b(FUSE, fuseIn);
      this.fuse = fuseIn;
   }

   public void func_70014_b(NBTTagCompound compound) {
      compound.func_74777_a("Fuse", (short)this.getFuse());
   }

   public void func_70037_a(NBTTagCompound compound) {
      this.setFuse(compound.func_74765_d("Fuse"));
   }

   public int getFuseDataManager() {
      return ((Integer)this.field_70180_af.func_187225_a(FUSE)).intValue();
   }

   public int getFuse() {
      return this.fuse;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_187214_a(FUSE, Integer.valueOf(40));
   }

   protected boolean func_70041_e_() {
      return false;
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   protected void func_70184_a(RayTraceResult result) {
   }

   static {
      FUSE = EntityDataManager.func_187226_a(EntityDynamite.class, DataSerializers.field_187192_b);
   }
}
