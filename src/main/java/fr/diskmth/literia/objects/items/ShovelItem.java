package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class ShovelItem extends ItemSpade implements IHasModel {
   private String typeOfShovel = "";

   public ShovelItem(String name, ToolMaterial material) {
      super(material);
      this.setRegistryName(name);
      this.func_77655_b(name);
      this.typeOfShovel = name;
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfShovel.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER) {
         return true;
      } else if (this.typeOfShovel.contains("tin") && repair.func_77973_b() == ItemsInit.TIN) {
         return true;
      } else if (this.typeOfShovel.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA) {
         return true;
      } else if (this.typeOfShovel.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfShovel.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
