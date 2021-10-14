/*     */ package fr.diskmth.literia.objects.entity;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.MoverType;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.datafix.DataFixer;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityDynamite extends EntityThrowable {
/*  21 */   private static final DataParameter<Integer> FUSE = EntityDataManager.func_187226_a(EntityDynamite.class, DataSerializers.field_187192_b);
/*     */   
/*     */   private int fuse;
/*     */ 
/*     */   
/*     */   public EntityDynamite(World worldIn) {
/*  27 */     super(worldIn);
/*  28 */     this.fuse = 40;
/*  29 */     this.field_70156_m = true;
/*  30 */     this.field_70178_ae = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityDynamite(World worldIn, EntityLivingBase throwerIn) {
/*  35 */     super(worldIn, throwerIn);
/*  36 */     setFuse(40);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityDynamite(World worldIn, double x, double y, double z) {
/*  41 */     super(worldIn, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerFixesEgg(DataFixer fixer) {
/*  46 */     EntityThrowable.func_189661_a(fixer, "ThrownDynamite");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte id) {
/*  53 */     if (id == 3) {
/*     */       
/*  55 */       double d0 = 0.08D;
/*  56 */       for (int i = 0; i < 8; i++) {
/*     */         
/*  58 */         this.field_70170_p.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, this.field_70165_t, this.field_70163_u, this.field_70161_v, (this.field_70146_Z.nextFloat() - 0.5D) * 0.08D, (this.field_70146_Z.nextFloat() - 0.5D) * 0.08D, (this.field_70146_Z.nextFloat() - 0.5D) * 0.08D, new int[] { Item.func_150891_b(Items.field_151110_aK) });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  66 */     this.field_70169_q = this.field_70165_t;
/*  67 */     this.field_70167_r = this.field_70163_u;
/*  68 */     this.field_70166_s = this.field_70161_v;
/*     */     
/*  70 */     if (!func_189652_ae())
/*     */     {
/*  72 */       this.field_70181_x -= 0.03999999910593033D;
/*     */     }
/*     */     
/*  75 */     func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  76 */     this.field_70159_w *= 0.9400000190734863D;
/*  77 */     this.field_70181_x *= 0.9400000190734863D;
/*  78 */     this.field_70179_y *= 0.9400000190734863D;
/*     */     
/*  80 */     if (this.field_70122_E) {
/*     */       
/*  82 */       this.field_70159_w *= 0.699999984079071D;
/*  83 */       this.field_70181_x *= 0.699999984079071D;
/*  84 */       this.field_70179_y *= -0.5D;
/*     */     } 
/*     */     
/*  87 */     if (this.field_70122_E)
/*     */     {
/*  89 */       this.fuse--;
/*     */     }
/*     */     
/*  92 */     if (this.fuse <= 0) {
/*     */       
/*  94 */       func_70106_y();
/*     */       
/*  96 */       if (!this.field_70170_p.field_72995_K)
/*     */       {
/*  98 */         this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.5F, true);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 103 */       func_70072_I();
/* 104 */       this.field_70170_p.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFuse(int fuseIn) {
/* 121 */     this.field_70180_af.func_187227_b(FUSE, Integer.valueOf(fuseIn));
/* 122 */     this.fuse = fuseIn;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound) {
/* 127 */     compound.func_74777_a("Fuse", (short)getFuse());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound) {
/* 132 */     setFuse(compound.func_74765_d("Fuse"));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFuseDataManager() {
/* 137 */     return ((Integer)this.field_70180_af.func_187225_a(FUSE)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFuse() {
/* 142 */     return this.fuse;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 148 */     this.field_70180_af.func_187214_a(FUSE, Integer.valueOf(40));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 160 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   protected void func_70184_a(RayTraceResult result) {}
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literia\objects\entity\EntityDynamite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */