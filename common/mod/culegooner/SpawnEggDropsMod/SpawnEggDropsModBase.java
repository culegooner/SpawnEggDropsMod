package mod.culegooner.SpawnEggDropsMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = SpawnEggDropsModLib.MOD_ID, name = SpawnEggDropsModLib.MOD_NAME, version = SpawnEggDropsModLib.VERSION_NUMBER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class SpawnEggDropsModBase {

	public static final Enchantment eSpawnDrop = new EnchantmentSpawnDrop(95, 2);
	
	@EventHandler
    public void preModInit(FMLPreInitializationEvent event) {
    }
 
	@EventHandler
    public void modInit(FMLInitializationEvent event) {
     
        MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());
        LanguageRegistry.instance().addStringLocalization("enchantment.espawndrop", "Drop Egg");    	
    }
    
	@EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
    	
    }
	
    
}
