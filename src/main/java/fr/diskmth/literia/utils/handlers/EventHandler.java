/*     */ package fr.diskmth.literia.utils.handlers;
/*     */ 
/*     */ import fr.diskmth.literia.init.NetworkInit;
/*     */ import fr.diskmth.literia.network.CancelIsBlockingPacket;
/*     */ import fr.diskmth.literia.network.SetIsBlockingPacket;
/*     */ import fr.diskmth.literia.utils.OldPvpUtils;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiMainMenu;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.MoverType;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.item.IItemPropertyGetter;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.FOVUpdateEvent;
/*     */ import net.minecraftforge.client.event.GuiOpenEvent;
/*     */ import net.minecraftforge.event.AnvilUpdateEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.player.AttackEntityEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.TickEvent;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class EventHandler
/*     */ {
/*     */   public static boolean isBlocking = false;
/*     */   public static boolean isEnablePacketSend = false;
/*     */   public static double playerSpeed;
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void onOpenGui(GuiOpenEvent event) {
/*  56 */     if (event.getGui() == null || event.getGui().getClass() == GuiMainMenu.class);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     if (event.getGui() == null || event.getGui().getClass() == GuiMultiplayer.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void OnLivingUpdate(LivingEvent.LivingUpdateEvent event) {
/*  70 */     if (event.getEntityLiving() instanceof EntityPlayer) {
/*     */       
/*  72 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/*  73 */       Block block = player.field_70170_p.func_180495_p(new BlockPos(player.field_70165_t, player.field_70163_u, player.field_70161_v)).func_177230_c();
/*     */       
/*  75 */       if (block instanceof fr.diskmth.literia.objects.blocks.LadderBlock)
/*     */       {
/*  77 */         if (!player.func_70093_af())
/*     */         {
/*  79 */           if (player.field_191988_bg > 0.0F) {
/*     */             
/*  81 */             player.func_70091_d(MoverType.SELF, 0.0D, 0.15D, 0.0D);
/*     */           }
/*     */           else {
/*     */             
/*  85 */             player.func_70091_d(MoverType.SELF, 0.0D, -0.15D, 0.0D);
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onAnvilUpdate(AnvilUpdateEvent event) {
/*  94 */     ItemStack rightStack = event.getRight();
/*  95 */     Item leftItem = event.getLeft().func_77973_b();
/*  96 */     Item rightItem = event.getRight().func_77973_b();
/*     */     
/*  98 */     if (leftItem instanceof fr.diskmth.literia.objects.items.UnclaimFinderItem && rightItem instanceof net.minecraft.item.ItemEnchantedBook) {
/*     */       
/* 100 */       event.setCanceled(true);
/*     */     
/*     */     }
/* 103 */     else if (leftItem instanceof fr.diskmth.literia.objects.items.StickItem && rightItem instanceof net.minecraft.item.ItemEnchantedBook) {
/*     */       
/* 105 */       Map<Enchantment, Integer> enchantments = EnchantmentHelper.func_82781_a(rightStack);
/*     */       
/* 107 */       if (enchantments.containsKey(Enchantments.field_185307_s)) {
/*     */         
/* 109 */         event.setCanceled(false);
/*     */       }
/*     */       else {
/*     */         
/* 113 */         event.setCanceled(true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onPlayerTickClient(TickEvent.PlayerTickEvent event) {
/* 122 */     if ((Minecraft.func_71410_x()).field_71474_y.field_74313_G.func_151470_d() && OldPvpUtils.getItemType(event.player.func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && !isEnablePacketSend) {
/*     */       
/* 124 */       NetworkInit.NETWORK.sendToServer((IMessage)new SetIsBlockingPacket("sended"));
/* 125 */       isEnablePacketSend = true;
/*     */     }
/* 127 */     else if (!(Minecraft.func_71410_x()).field_71474_y.field_74313_G.func_151470_d() && OldPvpUtils.getItemType(event.player.func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && isEnablePacketSend) {
/*     */       
/* 129 */       NetworkInit.NETWORK.sendToServer((IMessage)new CancelIsBlockingPacket("sended"));
/* 130 */       isEnablePacketSend = false;
/*     */     } 
/*     */     
/* 133 */     if (OldPvpUtils.getItemType(event.player.func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && isEnablePacketSend)
/*     */     {
/* 135 */       event.player.func_184586_b(EnumHand.MAIN_HAND).func_77973_b().func_185043_a(new ResourceLocation("blocking"), new IItemPropertyGetter()
/*     */           {
/*     */             
/*     */             public float func_185085_a(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
/*     */             {
/* 140 */               return OldPvpUtils.booleanToInt(EventHandler.isEnablePacketSend);
/*     */             }
/*     */ 
/*     */             
/*     */             public float call(ItemStack itemStack, @Nullable World world, @Nullable EntityLiving entityLiving) {
/* 145 */               return EventHandler.isEnablePacketSend ? 1.0F : 0.0F;
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onFOVUpdateByHitBlock(FOVUpdateEvent event) {
/* 155 */     if (playerSpeed == event.getEntity().func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b())
/*     */     {
/* 157 */       event.setNewfov(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void playerTickCommon(TickEvent.PlayerTickEvent event) {
/* 164 */     event.player.func_110148_a(SharedMonsterAttributes.field_188790_f).func_111128_a(1024.0D);
/*     */     
/* 166 */     if (!(event.player.func_130014_f_()).field_72995_K)
/*     */     {
/* 168 */       if (isBlocking) {
/*     */         
/* 170 */         event.player.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(event.player.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() / 6.0D);
/* 171 */         playerSpeed = event.player.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onEntityGotHurt(LivingHurtEvent event) {
/* 179 */     if (!(event.getEntityLiving().func_130014_f_()).field_72995_K)
/*     */     {
/* 181 */       if (event.getEntity() instanceof EntityPlayer && isBlocking && OldPvpUtils.canBeBlocked(event.getSource())) {
/*     */         
/* 183 */         event.setAmount(event.getAmount() * 0.66F);
/*     */       }
/* 185 */       else if (event.getSource().func_76346_g() instanceof EntityPlayer && OldPvpUtils.getItemType(((EntityPlayer)event.getSource().func_76346_g()).func_184614_ca()) == OldPvpUtils.itemType.AXE) {
/*     */         
/* 187 */         event.setAmount(OldPvpUtils.getOldDamages(((EntityPlayer)event.getSource().func_76346_g()).func_184614_ca()));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerAttack(AttackEntityEvent event) {
/* 195 */     if (!(event.getEntityPlayer().func_130014_f_()).field_72995_K)
/*     */     {
/* 197 */       if (OldPvpUtils.getItemType(event.getEntityPlayer().func_184586_b(EnumHand.MAIN_HAND)) == OldPvpUtils.itemType.SWORD && (event.getTarget() instanceof EntityLiving || event.getTarget() instanceof EntityPlayer)) {
/*     */         
/* 199 */         event.setCanceled(true);
/* 200 */         event.getTarget().func_70097_a(DamageSource.func_76365_a(event.getEntityPlayer()), ((ItemSword)event.getEntityPlayer().func_184586_b(EnumHand.MAIN_HAND).func_77973_b()).func_150931_i() + 4.0F);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nomap\Desktop\THE mod 1.0.jar!\fr\diskmth\literi\\utils\handlers\EventHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */