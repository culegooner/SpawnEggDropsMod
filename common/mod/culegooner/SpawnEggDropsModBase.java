package mod.culegooner;

import mod.culegooner.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;




@Mod(modid = SpawnEggDropsModLib.MOD_ID, name = SpawnEggDropsModLib.MOD_NAME, version = SpawnEggDropsModLib.VERSION_NUMBER)
//, dependencies = SpawnEggDropsModLib.DEPENDENCIES, certificateFingerprint = SpawnEggDropsModLib.FINGERPRINT)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class SpawnEggDropsModBase {

	
	@SidedProxy(
			clientSide = SpawnEggDropsModLib.CLIENT_PROXY_CLASS,
			serverSide = SpawnEggDropsModLib.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	
	
	@EventHandler
    public void preModInit(FMLPreInitializationEvent event) {
    }
 
	@EventHandler
    public void modInit(FMLInitializationEvent event) {
     
        MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());
            	
    }
    
	@EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
    	
    }
	
    
}
