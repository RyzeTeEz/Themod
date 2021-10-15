package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item implements IHasModel {
   public BasicItem(String name) {
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
