
package net.mcreator.druggiesmodmc.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.druggiesmodmc.DruggiesmodmcModElements;

@DruggiesmodmcModElements.ModElement.Tag
public class DruggiesModCreativeTabItemGroup extends DruggiesmodmcModElements.ModElement {
	public DruggiesModCreativeTabItemGroup(DruggiesmodmcModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdruggies_mod_creative_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
