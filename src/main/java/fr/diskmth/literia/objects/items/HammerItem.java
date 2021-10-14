/*     */ package fr.diskmth.literia.objects.items;
/*     */ 
/*     */ import fr.diskmth.literia.Main;
/*     */ import fr.diskmth.literia.init.ItemsInit;
/*     */ import fr.diskmth.literia.utils.interfaces.IHasModel;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class HammerItem extends ItemPickaxe implements IHasModel {
/*  21 */   private String typeOfHammer = "";
/*     */ 
/*     */   
/*     */   public HammerItem(String name, Item.ToolMaterial material) {
/*  25 */     super(material);
/*  26 */     func_77655_b(name);
/*  27 */     setRegistryName(name);
/*  28 */     func_77637_a(null);
/*  29 */     this.typeOfHammer = name;
/*  30 */     ItemsInit.ITEMS.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public RayTraceResult rayTrace(double blockReachDistance, float partialTicks, World world, EntityLivingBase e) {
/*  35 */     Vec3d vec3d = e.func_174824_e(partialTicks);
/*  36 */     Vec3d vec3d1 = e.func_70676_i(partialTicks);
/*  37 */     Vec3d vec3d2 = vec3d.func_72441_c(vec3d1.field_72450_a * blockReachDistance, vec3d1.field_72448_b * blockReachDistance, vec3d1.field_72449_c * blockReachDistance);
/*  38 */     return world.func_147447_a(vec3d, vec3d2, false, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_179218_a(ItemStack breaker, World w, IBlockState state, BlockPos pos, EntityLivingBase e) {
/*  44 */     if (e instanceof EntityPlayer && !w.field_72995_K) {
/*     */       
/*  46 */       EntityPlayer p = (EntityPlayer)e;
/*  47 */       RayTraceResult r = rayTrace(5.0D, 0.0F, w, e);
/*     */       
/*  49 */       if (r.field_72313_a == RayTraceResult.Type.BLOCK) {
/*     */         
/*  51 */         int x = pos.func_177958_n();
/*  52 */         int y = pos.func_177956_o();
/*  53 */         int z = pos.func_177952_p();
/*     */         
/*  55 */         EnumFacing side = r.field_178784_b;
/*     */         
/*  57 */         if (side == EnumFacing.DOWN || side == EnumFacing.UP) {
/*     */ 
/*     */           
/*  60 */           if (w.func_180495_p(new BlockPos(x + 1, y, z - 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  62 */             destroyAndDropBlock(w, p, breaker, x + 1, y, z - 1);
/*     */           }
/*  64 */           if (w.func_180495_p(new BlockPos(x + 1, y, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  66 */             destroyAndDropBlock(w, p, breaker, x + 1, y, z);
/*     */           }
/*  68 */           if (w.func_180495_p(new BlockPos(x + 1, y, z + 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  70 */             destroyAndDropBlock(w, p, breaker, x + 1, y, z + 1);
/*     */           }
/*  72 */           if (w.func_180495_p(new BlockPos(x, y, z - 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  74 */             destroyAndDropBlock(w, p, breaker, x, y, z - 1);
/*     */           }
/*     */           
/*  77 */           if (w.func_180495_p(new BlockPos(x, y, z + 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  79 */             destroyAndDropBlock(w, p, breaker, x, y, z + 1);
/*     */           }
/*  81 */           if (w.func_180495_p(new BlockPos(x - 1, y, z - 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  83 */             destroyAndDropBlock(w, p, breaker, x - 1, y, z - 1);
/*     */           }
/*  85 */           if (w.func_180495_p(new BlockPos(x - 1, y, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  87 */             destroyAndDropBlock(w, p, breaker, x - 1, y, z);
/*     */           }
/*  89 */           if (w.func_180495_p(new BlockPos(x - 1, y, z + 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/*  91 */             destroyAndDropBlock(w, p, breaker, x - 1, y, z + 1);
/*     */           
/*     */           }
/*     */         
/*     */         }
/*  96 */         else if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH) {
/*     */           
/*  98 */           if (w.func_180495_p(new BlockPos(x + 1, y + 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 100 */             destroyAndDropBlock(w, p, breaker, x + 1, y + 1, z);
/*     */           }
/* 102 */           if (w.func_180495_p(new BlockPos(x, y + 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 104 */             destroyAndDropBlock(w, p, breaker, x, y + 1, z);
/*     */           }
/* 106 */           if (w.func_180495_p(new BlockPos(x - 1, y + 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 108 */             destroyAndDropBlock(w, p, breaker, x - 1, y + 1, z);
/*     */           }
/* 110 */           if (w.func_180495_p(new BlockPos(x + 1, y, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 112 */             destroyAndDropBlock(w, p, breaker, x + 1, y, z);
/*     */           }
/*     */           
/* 115 */           if (w.func_180495_p(new BlockPos(x - 1, y, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 117 */             destroyAndDropBlock(w, p, breaker, x - 1, y, z);
/*     */           }
/* 119 */           if (w.func_180495_p(new BlockPos(x + 1, y - 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 121 */             destroyAndDropBlock(w, p, breaker, x + 1, y - 1, z);
/*     */           }
/* 123 */           if (w.func_180495_p(new BlockPos(x, y - 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 125 */             destroyAndDropBlock(w, p, breaker, x, y - 1, z);
/*     */           }
/* 127 */           if (w.func_180495_p(new BlockPos(x - 1, y - 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 129 */             destroyAndDropBlock(w, p, breaker, x - 1, y - 1, z);
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 134 */         else if (side == EnumFacing.EAST || side == EnumFacing.WEST) {
/*     */           
/* 136 */           if (w.func_180495_p(new BlockPos(x, y + 1, z + 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 138 */             destroyAndDropBlock(w, p, breaker, x, y + 1, z + 1);
/*     */           }
/* 140 */           if (w.func_180495_p(new BlockPos(x, y + 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 142 */             destroyAndDropBlock(w, p, breaker, x, y + 1, z);
/*     */           }
/* 144 */           if (w.func_180495_p(new BlockPos(x, y + 1, z - 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 146 */             destroyAndDropBlock(w, p, breaker, x, y + 1, z - 1);
/*     */           }
/* 148 */           if (w.func_180495_p(new BlockPos(x, y, z + 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 150 */             destroyAndDropBlock(w, p, breaker, x, y, z + 1);
/*     */           }
/*     */           
/* 153 */           if (w.func_180495_p(new BlockPos(x, y, z - 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 155 */             destroyAndDropBlock(w, p, breaker, x, y, z - 1);
/*     */           }
/* 157 */           if (w.func_180495_p(new BlockPos(x, y - 1, z + 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 159 */             destroyAndDropBlock(w, p, breaker, x, y - 1, z + 1);
/*     */           }
/* 161 */           if (w.func_180495_p(new BlockPos(x, y - 1, z)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 163 */             destroyAndDropBlock(w, p, breaker, x, y - 1, z);
/*     */           }
/* 165 */           if (w.func_180495_p(new BlockPos(x, y - 1, z - 1)).func_177230_c() != Blocks.field_150343_Z)
/*     */           {
/* 167 */             destroyAndDropBlock(w, p, breaker, x, y - 1, z - 1);
/*     */           }
/*     */         } 
/* 170 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     breaker.func_77972_a(1, e);
/* 175 */     return super.func_179218_a(breaker, w, state, pos, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void destroyAndDropBlock(World w, EntityPlayer p, ItemStack breaker, int x, int y, int z) {
/* 181 */     BlockPos pos = new BlockPos(x, y, z);
/*     */     
/* 183 */     if (w.func_180495_p(pos).func_185887_b(w, pos) >= 0.0F && w.func_180495_p(pos).func_177230_c().func_149688_o(w.func_180495_p(pos).func_177230_c().func_176223_P()) == Material.field_151576_e) {
/*     */       
/* 185 */       w.func_180495_p(pos).func_177230_c().func_180657_a(w, p, pos, w.func_180495_p(pos), w.func_175625_s(pos), breaker);
/* 186 */       w.func_175698_g(pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82789_a(ItemStack input, ItemStack repair) {
/* 192 */     if (this.typeOfHammer.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA)
/*     */     {
/* 194 */       return true;
/*     */     }
/*     */     
/* 197 */     if (this.typeOfHammer.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM)
/*     */     {
/* 199 */       return true;
/*     */     }
/*     */     
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerModels() {
/* 208 */     Main.proxy.registerItemRenderer((Item)this, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\objects\items\HammerItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */