package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class PickaxeItem extends ItemPickaxe implements IHasModel {
   private String typeOfPickaxe = "";

   public PickaxeItem(String name, ToolMaterial material) {
      super(material);
      this.setRegistryName(name);
      this.func_77655_b(name);
      this.typeOfPickaxe = name;
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfPickaxe.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER) {
         return true;
      } else if (this.typeOfPickaxe.contains("tin") && repair.func_77973_b() == ItemsInit.TIN) {
         return true;
      } else if (this.typeOfPickaxe.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA) {
         return true;
      } else if (this.typeOfPickaxe.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfPickaxe.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
