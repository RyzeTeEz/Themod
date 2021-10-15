package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class SwordItem extends ItemSword implements IHasModel {
   private String typeOfSword = "";

   public SwordItem(String name, ToolMaterial material) {
      super(material);
      this.setRegistryName(name);
      this.func_77655_b(name);
      this.typeOfSword = name;
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      if (this.typeOfSword.contains("copper") && repair.func_77973_b() == ItemsInit.COPPER) {
         return true;
      } else if (this.typeOfSword.contains("tin") && repair.func_77973_b() == ItemsInit.TIN) {
         return true;
      } else if (this.typeOfSword.contains("isolua") && repair.func_77973_b() == ItemsInit.ISOLUA) {
         return true;
      } else if (this.typeOfSword.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM) {
         return true;
      } else {
         return this.typeOfSword.contains("demonite") && repair.func_77973_b() == ItemsInit.DEMONITE;
      }
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
