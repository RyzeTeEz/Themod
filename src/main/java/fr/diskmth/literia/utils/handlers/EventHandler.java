package fr.diskmth.literia.utils.handlers;

import fr.diskmth.literia.init.NetworkInit;
import fr.diskmth.literia.network.CancelIsBlockingPacket;
import fr.diskmth.literia.network.SetIsBlockingPacket;
import fr.diskmth.literia.objects.blocks.LadderBlock;
import fr.diskmth.literia.objects.items.StickItem;
import fr.diskmth.literia.objects.items.UnclaimFinderItem;
import fr.diskmth.literia.utils.OldPvpUtils;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class EventHandler {
   public static boolean isBlocking = false;
   public static boolean isEnablePacketSend = false;
   public static double playerSpeed;

   @SubscribeEvent
   @SideOnly(Side.CLIENT)
   public static void onOpenGui(GuiOpenEvent event) {
      if (event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class) {
         ;
      }

      if (event.getGui() != null && event.getGui().getClass() == GuiMultiplayer.class) {
         ;
      }

   }

   @SubscribeEvent
   public void OnLivingUpdate(LivingUpdateEvent event) {
      if (event.getEntityLiving() instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)event.getEntityLiving();
         Block block = player.field_70170_p.func_180495_p(new BlockPos(player.field_70165_t, player.field_70163_u, player.field_70161_v)).func_177230_c();
         if (block instanceof LadderBlock && !player.func_70093_af()) {
            if (player.field_191988_bg > 0.0F) {
               player.func_70091_d(MoverType.SELF, 0.0D, 0.15D, 0.0D);
            } else {
               player.func_70091_d(MoverType.SELF, 0.0D, -0.15D, 0.0D);
            }
         }
      }

   }

   @SubscribeEvent
   public static void onAnvilUpdate(AnvilUpdateEvent event) {
      ItemStack rightStack = event.getRight();
      Item leftItem = event.getLeft().func_77973_b();
      Item rightItem = event.getRight().func_77973_b();
      if (leftItem instanceof UnclaimFinderItem && rightItem instanceof ItemEnchantedBook) {
         event.setCanceled(true);
      } else if (leftItem instanceof StickItem && rightItem instanceof ItemEnchantedBook) {
         Map enchantments = EnchantmentHelper.func_82781_a(rightStack);
         if (enchantments.containsKey(Enchantments.field_185307_s)) {
            event.setCanceled(false);
         } else {
            event.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   @SideOnly(Side.CLIENT)
   public void onPlayerTickClient(PlayerTickEvent event) {
      if (Minecraft.func_71410_x().field_71474_y.field_74313_G.func_151470_d() && OldPvpUtils.getItemType(event.player.func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && !isEnablePacketSend) {
         NetworkInit.NETWORK.sendToServer(new SetIsBlockingPacket("sended"));
         isEnablePacketSend = true;
      } else if (!Minecraft.func_71410_x().field_71474_y.field_74313_G.func_151470_d() && OldPvpUtils.getItemType(event.player.func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && isEnablePacketSend) {
         NetworkInit.NETWORK.sendToServer(new CancelIsBlockingPacket("sended"));
         isEnablePacketSend = false;
      }

      if (OldPvpUtils.getItemType(event.player.func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && isEnablePacketSend) {
         event.player.func_184586_b(EnumHand.MAIN_HAND).func_77973_b().func_185043_a(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            public float func_185085_a(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
               return (float)OldPvpUtils.booleanToInt(EventHandler.isEnablePacketSend);
            }

            public float call(ItemStack itemStack, @Nullable World world, @Nullable EntityLiving entityLiving) {
               return EventHandler.isEnablePacketSend ? 1.0F : 0.0F;
            }
         });
      }

   }

   @SubscribeEvent
   @SideOnly(Side.CLIENT)
   public void onFOVUpdateByHitBlock(FOVUpdateEvent event) {
      if (playerSpeed == event.getEntity().func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b()) {
         event.setNewfov(1.0F);
      }

   }

   @SubscribeEvent
   public void playerTickCommon(PlayerTickEvent event) {
      event.player.func_110148_a(SharedMonsterAttributes.field_188790_f).func_111128_a(1024.0D);
      if (!event.player.func_130014_f_().field_72995_K && isBlocking) {
         event.player.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(event.player.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() / 6.0D);
         playerSpeed = event.player.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b();
      }

   }

   @SubscribeEvent
   public void onEntityGotHurt(LivingHurtEvent event) {
      if (!event.getEntityLiving().func_130014_f_().field_72995_K) {
         if (event.getEntity() instanceof EntityPlayer && isBlocking && OldPvpUtils.canBeBlocked(event.getSource())) {
            event.setAmount(event.getAmount() * 0.66F);
         } else if (event.getSource().func_76346_g() instanceof EntityPlayer && OldPvpUtils.getItemType(((EntityPlayer)event.getSource().func_76346_g()).func_184614_ca()) == OldPvpUtils.itemType.AXE) {
            event.setAmount(OldPvpUtils.getOldDamages(((EntityPlayer)event.getSource().func_76346_g()).func_184614_ca()));
         }
      }

   }

   @SubscribeEvent
   public void onPlayerAttack(AttackEntityEvent event) {
      if (!event.getEntityPlayer().func_130014_f_().field_72995_K && OldPvpUtils.getItemType(event.getEntityPlayer().func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && (event.getTarget() instanceof EntityLiving || event.getTarget() instanceof EntityPlayer)) {
         event.setCanceled(true);
         event.getTarget().func_70097_a(DamageSource.func_76365_a(event.getEntityPlayer()), ((ItemSword)event.getEntityPlayer().func_184586_b(EnumHand.MAIN_HAND).func_77973_b()).func_150931_i() + 4.0F);
      }

   }
}
