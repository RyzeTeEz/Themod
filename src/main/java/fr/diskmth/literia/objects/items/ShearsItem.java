package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;

public class ShearsItem extends ItemShears implements IHasModel {
   private String typeOfshears = "";

   public ShearsItem(String name, int maxDamage) {
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.func_77625_d(1);
      this.func_77656_e(maxDamage);
      this.func_77637_a((CreativeTabs)null);
      this.typeOfshears = name;
      ItemsInit.ITEMS.add(this);
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      return this.typeOfshears.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM;
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
