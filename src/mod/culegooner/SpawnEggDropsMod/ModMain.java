package mod.culegooner.SpawnEggDropsMod;

import java.util.logging.Level;

import mod.culegooner.SpawnEggDropsMod.Events.HandlersInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModLib.MOD_ID, name = ModLib.MOD_NAME, version = ModLib.VERSION_NUMBER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModMain {

	@Instance(ModLib.MOD_ID)
	public static ModMain instance;

	public static final Enchantment eSpawnEggDrop = new EnchantmentSpawnEggDrop(95, 2);
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		// event.registerServerCommand(new CommandMod());
	}

	@EventHandler
	public void preModInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			cfg.load();

			HandlersInit.DROPFISH = cfg.get(Configuration.CATEGORY_GENERAL, HandlersInit.DROPFISH_NAME, HandlersInit.DROPFISH_DEFAULT).getBoolean(HandlersInit.DROPFISH_DEFAULT);
			HandlersInit.EGGDROPCHANCE = cfg.get(Configuration.CATEGORY_GENERAL, HandlersInit.EGGDROPCHANCE_NAME, HandlersInit.EGGDROPCHANCE_DEFAULT).getDouble(HandlersInit.EGGDROPCHANCE_DEFAULT);
			HandlersInit.FISHCHANCE = cfg.get(Configuration.CATEGORY_GENERAL, HandlersInit.FISHCHANCE_NAME, HandlersInit.FISHCHANCE_DEFAULT).getDouble(HandlersInit.FISHCHANCE_DEFAULT);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, ModLib.MOD_NAME + " has a problem loading it's configuration");
		} finally {
			if (cfg.hasChanged())
				cfg.save();
		}

		LanguageRegistry.instance().loadLocalization(ModLib.LANG_RESOURCE_LOCATION + "en_US.xml", "en_US", true);

	}

	@EventHandler
	public void modInit(FMLInitializationEvent event) {

		HandlersInit.init();
				
	}

	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {

	}

}
