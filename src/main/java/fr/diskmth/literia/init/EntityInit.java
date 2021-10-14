/*    */ package fr.diskmth.literia.init;
/*    */ 
/*    */ import fr.diskmth.literia.objects.entity.EntityDynamite;
/*    */ import fr.diskmth.literia.objects.entity.EntityPillerTNTPrimed;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityInit
/*    */ {
/*    */   public static void registerEntity() {
/* 13 */     EntityRegistry.registerModEntity(new ResourceLocation("literiamod", "piller_tnt"), EntityPillerTNTPrimed.class, "entity_piller_tnt_primed", 0, "literiamod", 128, 1, true);
/* 14 */     EntityRegistry.registerModEntity(new ResourceLocation("literiamod", "dynamite"), EntityDynamite.class, "entity_dynamite", 1, "literiamod", 128, 1, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\oceli\Desktop\literiamod-1.0.jar!\fr\diskmth\literia\init\EntityInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */