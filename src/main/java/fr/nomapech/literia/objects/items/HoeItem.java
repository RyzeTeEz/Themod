package fr.nomapech.literia.objects.items;

import fr.nomapech.literia.Main;
import fr.nomapech.literia.init.ItemsInit;
import fr.nomapech.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class HoeItem extends ItemHoe implements IHasModel {
   private String typeOfHoe = "";

   public HoeItem(String name, ToolMaterial material) {
      super(material);
      this.setTranslationKey(name);
      this.setRegistryName(name);
      this.typeOfHoe = name;
      this.setCreativeTab((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      return this.typeOfHoe.contains("literium") && repair.getItem() == ItemsInit.LITERIUM;
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
