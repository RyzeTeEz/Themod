/*     */ package fr.diskmth.literia.objects.entity;
/*     */ 
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.MoverType;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ 
/*     */ public class EntityPillerTNTPrimed
/*     */   extends Entity
/*     */   implements IEntityAdditionalSpawnData {
/*  21 */   private static final DataParameter<Integer> FUSE = EntityDataManager.func_187226_a(EntityPillerTNTPrimed.class, DataSerializers.field_187192_b);
/*     */   
/*     */   @Nullable
/*     */   private EntityLivingBase tntPlacedBy;
/*     */   private int fuse;
/*     */   
/*     */   public EntityPillerTNTPrimed(World worldIn) {
/*  28 */     super(worldIn);
/*  29 */     this.fuse = 80;
/*  30 */     this.field_70156_m = true;
/*  31 */     this.field_70178_ae = true;
/*  32 */     func_70105_a(0.98F, 0.98F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPillerTNTPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
/*  37 */     this(worldIn);
/*  38 */     func_70107_b(x, y, z);
/*  39 */     float f = (float)(Math.random() * 6.283185307179586D);
/*  40 */     this.field_70159_w = (-((float)Math.sin(f)) * 0.02F);
/*  41 */     this.field_70181_x = 0.20000000298023224D;
/*  42 */     this.field_70179_y = (-((float)Math.cos(f)) * 0.02F);
/*  43 */     setFuse(80);
/*  44 */     this.field_70169_q = x;
/*  45 */     this.field_70167_r = y;
/*  46 */     this.field_70166_s = z;
/*  47 */     this.tntPlacedBy = igniter;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  52 */     this.field_70180_af.func_187214_a(FUSE, Integer.valueOf(80));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/*  62 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  67 */     this.field_70169_q = this.field_70165_t;
/*  68 */     this.field_70167_r = this.field_70163_u;
/*  69 */     this.field_70166_s = this.field_70161_v;
/*     */     
/*  71 */     if (!func_189652_ae())
/*     */     {
/*  73 */       this.field_70181_x -= 0.03999999910593033D;
/*     */     }
/*     */     
/*  76 */     func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  77 */     this.field_70159_w *= 0.9800000190734863D;
/*  78 */     this.field_70181_x *= 0.9800000190734863D;
/*  79 */     this.field_70179_y *= 0.9800000190734863D;
/*     */     
/*  81 */     if (this.field_70122_E) {
/*     */       
/*  83 */       this.field_70159_w *= 0.699999988079071D;
/*  84 */       this.field_70179_y *= 0.699999988079071D;
/*  85 */       this.field_70181_x *= -0.5D;
/*     */     } 
/*     */     
/*  88 */     this.fuse--;
/*     */     
/*  90 */     if (this.fuse <= 0) {
/*     */       
/*  92 */       func_70106_y();
/*     */       
/*  94 */       if (!this.field_70170_p.field_72995_K)
/*     */       {
/*  96 */         explode();
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 101 */       func_70072_I();
/* 102 */       this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void explode() {
/* 108 */     float explodeIntensity = 4.0F;
/* 109 */     this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + (this.field_70131_O / 16.0F), this.field_70161_v, explodeIntensity, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound compound) {
/* 114 */     compound.func_74777_a("Fuse", (short)getFuse());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound compound) {
/* 119 */     setFuse(compound.func_74765_d("Fuse"));
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public EntityLivingBase getTntPlacedBy() {
/* 125 */     return this.tntPlacedBy;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 130 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFuse(int fuseIn) {
/* 135 */     this.field_70180_af.func_187227_b(FUSE, Integer.valueOf(fuseIn));
/* 136 */     this.fuse = fuseIn;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_184206_a(DataParameter<?> key) {
/* 141 */     if (FUSE.equals(key))
/*     */     {
/* 143 */       this.fuse = getFuseDataManager();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFuseDataManager() {
/* 149 */     return ((Integer)this.field_70180_af.func_187225_a(FUSE)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFuse() {
/* 154 */     return this.fuse;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf buffer) {
/* 159 */     buffer.writeInt(this.fuse);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf additionalData) {
/* 164 */     this.fuse = additionalData.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation getEntityTexture(EntityPillerTNTPrimed entity) {
/* 169 */     return TextureMap.field_110575_b;
/*     */   }
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\entity\EntityPillerTNTPrimed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */