package fr.diskmth.literia.objects.items;

import fr.diskmth.literia.Main;
import fr.diskmth.literia.init.ItemsInit;
import fr.diskmth.literia.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class HoeItem extends ItemHoe implements IHasModel {
   private String typeOfHoe = "";

   public HoeItem(String name, ToolMaterial material) {
      super(material);
      this.func_77655_b(name);
      this.setRegistryName(name);
      this.typeOfHoe = name;
      this.func_77637_a((CreativeTabs)null);
      ItemsInit.ITEMS.add(this);
   }

   public boolean func_82789_a(ItemStack input, ItemStack repair) {
      return this.typeOfHoe.contains("literium") && repair.func_77973_b() == ItemsInit.LITERIUM;
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0);
   }
}
