package fr.nomapech.literia.init;

import fr.nomapech.literia.objects.entity.EntityDynamite;
import fr.nomapech.literia.objects.entity.EntityPillerTNTPrimed;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
   public static void registerEntity() {
      EntityRegistry.registerModEntity(new ResourceLocation("literiamod", "piller_tnt"), EntityPillerTNTPrimed.class, "entity_piller_tnt_primed", 0, "literiamod", 128, 1, true);
      EntityRegistry.registerModEntity(new ResourceLocation("literiamod", "dynamite"), EntityDynamite.class, "entity_dynamite", 1, "literiamod", 128, 1, true);
   }
}
