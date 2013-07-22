package mod.culegooner.SpawnEggDropsMod.Events;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class CreepersDropsFishHandler {

	//algorithm by Pahimar
	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event) {
		if (event.source.getDamageType().equals("player")) {
			EntityPlayer p = (EntityPlayer) event.source.getEntity();

			if (event.entityLiving instanceof EntityCreeper) {
				double rand = Math.random();

				if (rand < HandlersInit.FISHCHANCE) {
					event.entityLiving.dropItem(Item.fishRaw.itemID, 1);
				}
			}

		}

		if (event.source.getSourceOfDamage() instanceof EntityArrow) {
			if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null) {
				if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer) {

					EntityPlayer p = (EntityPlayer) event.source.getEntity();

					if (event.entityLiving instanceof EntityCreeper) {
						double rand = Math.random();

						if (rand < HandlersInit.FISHCHANCE) {
							event.entityLiving.dropItem(Item.fishRaw.itemID, 1);
						}

					}

				}

			}

		}

	}
}
