
package net.mcreator.druggiesmodmc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.druggiesmodmc.procedures.CiggiesWhenSmokedProcedure;
import net.mcreator.druggiesmodmc.itemgroup.DruggiesModCreativeTabItemGroup;
import net.mcreator.druggiesmodmc.DruggiesmodmcModElements;

import java.util.Collections;

@DruggiesmodmcModElements.ModElement.Tag
public class CiggiesItem extends DruggiesmodmcModElements.ModElement {
	@ObjectHolder("druggiesmodmc:ciggies")
	public static final Item block = null;

	public CiggiesItem(DruggiesmodmcModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(DruggiesModCreativeTabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.3f).setAlwaysEdible().meat().build()));
			setRegistryName("ciggies");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			CiggiesWhenSmokedProcedure.executeProcedure(Collections.EMPTY_MAP);
			return retval;
		}
	}
}
