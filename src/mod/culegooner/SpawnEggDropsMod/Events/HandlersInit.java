package mod.culegooner.SpawnEggDropsMod.Events;

import net.minecraftforge.common.MinecraftForge;

public class HandlersInit {

	public static boolean DROPFISH_DEFAULT = true;
	public static boolean DROPFISH;

	public static double FISHCHANCE_DEFAULT = 0.50;
	public static double FISHCHANCE;

	public static double EGGDROPCHANCE_DEFAULT = 0.50;
	public static double EGGDROPCHANCE;
	
	public static final String DROPFISH_NAME = "creeperDropfish";
	public static final String EGGDROPCHANCE_NAME = "spawnEggDropChance";
	public static final String FISHCHANCE_NAME = "creeperDropfishChance";

	public static void init() {
		if (DROPFISH)
			MinecraftForge.EVENT_BUS.register(new CreepersDropsFishHandler());
		MinecraftForge.EVENT_BUS.register(new SpawnEggDropHandler());
	}
}