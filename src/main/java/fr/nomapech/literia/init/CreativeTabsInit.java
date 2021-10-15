package fr.nomapech.literia.init;

import fr.nomapech.literia.objects.creativetabs.CreativeTabLiteria1;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsInit {
   public static CreativeTabs LITERIA_TAB_1;

   public static void registerCreativetabs() {
      LITERIA_TAB_1 = new CreativeTabLiteria1("literia_tab_1");
   }
}
