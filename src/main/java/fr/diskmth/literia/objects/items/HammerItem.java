package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;

public class HammerItem extends ItemPickaxe implements IHasModel {
   private String typeOfHammer = "";

   public HammerItem(String name, ToolMaterial material) {
      super(material);
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77637_a((CreativeTabs)null);
      this.typeOfHammer = name;
      ItemsInit.ITEMS.add(this);
   }

   public RayTraceResult rayTrace(double blockReachDistance, float partialTicks, World world, EntityLivingBase e) {
      Vec3d vec3d = e.func_174824_e(partialTicks);
      Vec3d vec3d1 = e.func_70676_i(partialTicks);
      Vec3d vec3d2 = vec3d.func_72441_c(vec3d1.field_72450_a * blockReachDistance, vec3d1.field_72448_b * blockReachDistance, vec3d1.field_72449_c * blockReachDistance);
      return world.func_147447_a(vec3d, vec3d2, false, false, true);
   }

   public boolean func_179218_a(ItemStack breaker, World w, IBlockState state, BlockPos pos, EntityLivingBase e) {
      if (e instanceof EntityPlayer && !w.field_72995_K) {
         EntityPlayer p = (EntityPlayer)e;
         RayTraceResult r = this.rayTrace(5.0D, 0.0F, w, e);
         if (r.field_72313_a == Type.BLOCK) {
            int x = pos.func_177958_n();
            int y = pos.func_177956_o();
            int z = pos.func_177952_p();
            EnumFacing side = r.field_178784_b;
            if (side != EnumFacing.DOWN && side != EnumFacing.UP) {
               if (side != EnumFacing.NORTH && side != EnumFacing.SOUTH) {
                  if (side == EnumFacing.EAST || side == EnumFacing.WEST) {
                     if (w.func_180495_p(new BlockPos(x, y + 1, z + 1)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y + 1, z + 1);
                     }

                     if (w.func_180495_p(new BlockPos(x, y + 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                     }

                     if (w.func_180495_p(new BlockPos(x, y + 1, z - 1)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y + 1, z - 1);
                     }

                     if (w.func_180495_p(new BlockPos(x, y, z + 1)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
                     }

                     if (w.func_180495_p(new BlockPos(x, y, z - 1)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
                     }

                     if (w.func_180495_p(new BlockPos(x, y - 1, z + 1)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y - 1, z + 1);
                     }

                     if (w.func_180495_p(new BlockPos(x, y - 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                     }

                     if (w.func_180495_p(new BlockPos(x, y - 1, z - 1)).func_177230_c() != Blocks.field_150343_Z) {
                        this.destroyAndDropBlock(w, p, breaker, x, y - 1, z - 1);
                     }
                  }
               } else {
                  if (w.func_180495_p(new BlockPos(x + 1, y + 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x + 1, y + 1, z);
                  }

                  if (w.func_180495_p(new BlockPos(x, y + 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x, y + 1, z);
                  }

                  if (w.func_180495_p(new BlockPos(x - 1, y + 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x - 1, y + 1, z);
                  }

                  if (w.func_180495_p(new BlockPos(x + 1, y, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
                  }

                  if (w.func_180495_p(new BlockPos(x - 1, y, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
                  }

                  if (w.func_180495_p(new BlockPos(x + 1, y - 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x + 1, y - 1, z);
                  }

                  if (w.func_180495_p(new BlockPos(x, y - 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x, y - 1, z);
                  }

                  if (w.func_180495_p(new BlockPos(x - 1, y - 1, z)).func_177230_c() != Blocks.field_150343_Z) {
                     this.destroyAndDropBlock(w, p, breaker, x - 1, y - 1, z);
                  }
               }
            } else {
               if (w.func_180495_p(new BlockPos(x + 1, y, z - 1)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x + 1, y, z - 1);
               }

               if (w.func_180495_p(new BlockPos(x + 1, y, z)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x + 1, y, z);
               }

               if (w.func_180495_p(new BlockPos(x + 1, y, z + 1)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x + 1, y, z + 1);
               }

               if (w.func_180495_p(new BlockPos(x, y, z - 1)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x, y, z - 1);
               }

               if (w.func_180495_p(new BlockPos(x, y, z + 1)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x, y, z + 1);
               }

               if (w.func_180495_p(new BlockPos(x - 1, y, z - 1)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x - 1, y, z - 1);
               }

               if (w.func_180495_p(new BlockPos(x - 1, y, z)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x - 1, y, z);
               }

               if (w.func_180495_p(new BlockPos(x - 1, y, z + 1)).func_177230_c() != Blocks.field_150343_Z) {
                  this.destroyAndDropBlock(w, p, breaker, x - 1, y, z + 1);
               }
            }

            return true;
         }
      }

      breaker.func_77972_a(1, e);
      return super.func_179218_a(breaker, w, state, pos, e);
   }

   private void destroyAndDropBlock(World w, EntityPlayer p, ItemStack breaker, int x, int y, int z) {
      BlockPos pos = new BlockPos(x, y, z);
      if (w.func_180495_p(pos).func_185887_b(w, pos) >= 0.0F && w.func_180495_p(pos).func_177230_c().func_149688_o(w.func_180495_p(pos).func_177230_c().func_176223_P()) == Material.field_151576_e) {
         w.func_180495_p(pos).func_177230_c().func_180657_a(w, p, pos, w.func_180495_p(pos), w.func_175625_s(pos), breaker);
         w.func_175698_g(pos);
      }

   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfHammer.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA) {
         return true;
      } else {
         return this.typeOfHammer.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
