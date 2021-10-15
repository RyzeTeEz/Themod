package fr.nomapech.literia.utils.handlers;

import fr.nomapech.literia.objects.blocks.LadderBlock;
import fr.nomapech.literia.objects.items.StickItem;
import fr.nomapech.literia.objects.items.UnclaimFinderItem;
import fr.nomapech.literia.utils.OldPvpUtils;
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
         Block block = player.world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ)).getBlock();
         if (block instanceof LadderBlock && !player.isSneaking()) {
            if (player.moveForward > 0.0F) {
               player.move(MoverType.SELF, 0.0D, 0.15D, 0.0D);
            } else {
               player.move(MoverType.SELF, 0.0D, -0.15D, 0.0D);
            }
         }
      }

   }

   @SubscribeEvent
   public static void onAnvilUpdate(AnvilUpdateEvent event) {
      ItemStack rightStack = event.getRight();
      Item leftItem = event.getLeft().getItem();
      Item rightItem = event.getRight().getItem();
      if (leftItem instanceof UnclaimFinderItem && rightItem instanceof ItemEnchantedBook) {
         event.setCanceled(true);
      } else if (leftItem instanceof StickItem && rightItem instanceof ItemEnchantedBook) {
         Map enchantments = EnchantmentHelper.getEnchantments(rightStack);
         if (enchantments.containsKey(Enchantments.UNBREAKING)) {
            event.setCanceled(false);
         } else {
            event.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   @SideOnly(Side.CLIENT)
   public void onPlayerTickClient(PlayerTickEvent event) {
      if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown() && OldPvpUtils.getItemType(event.player.getHeldItem(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && !isEnablePacketSend) {
      } else if (!Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown() && OldPvpUtils.getItemType(event.player.getHeldItem(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && isEnablePacketSend) {
      }

      if (OldPvpUtils.getItemType(event.player.getHeldItem(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && isEnablePacketSend) {
         event.player.getHeldItem(EnumHand.MAIN_HAND).getItem().addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @Override
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
               return 0;
            }

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
      if (playerSpeed == event.getEntity().getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue()) {
         event.setNewfov(1.0F);
      }

   }

   @SubscribeEvent
   public void playerTickCommon(PlayerTickEvent event) {
      event.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1024.0D);
      if (!event.player.getEntityWorld().isRemote && isBlocking) {
         event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue() / 6.0D);
         playerSpeed = event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();
      }

   }

   @SubscribeEvent
   public void onEntityGotHurt(LivingHurtEvent event) {
      if (!event.getEntityLiving().getEntityWorld().isRemote) {
         if (event.getEntity() instanceof EntityPlayer && isBlocking && OldPvpUtils.canBeBlocked(event.getSource())) {
            event.setAmount(event.getAmount() * 0.66F);
         } else if (event.getSource().getTrueSource() instanceof EntityPlayer && OldPvpUtils.getItemType(((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand()) == OldPvpUtils.itemType.AXE) {
            event.setAmount(OldPvpUtils.getOldDamages(((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand()));
         }
      }

   }

   @SubscribeEvent
   public void onPlayerAttack(AttackEntityEvent event) {
      if (!event.getEntityPlayer().getEntityWorld().isRemote && OldPvpUtils.getItemType(event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && (event.getTarget() instanceof EntityLiving || event.getTarget() instanceof EntityPlayer)) {
         event.setCanceled(true);
         event.getTarget().attackEntityFrom(DamageSource.causePlayerDamage(event.getEntityPlayer()), ((ItemSword)event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND).getItem()).getAttackDamage() + 4.0F);
      }

   }
}
