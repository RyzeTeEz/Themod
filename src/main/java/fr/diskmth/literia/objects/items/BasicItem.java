package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
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
