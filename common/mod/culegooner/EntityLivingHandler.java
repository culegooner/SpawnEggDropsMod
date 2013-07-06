package mod.culegooner;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;



public class EntityLivingHandler {

	@ForgeSubscribe
    public void onEntityLivingDeath(LivingDeathEvent event) {
    	FMLLog.info("WOOOHOOO onEntityLivingDeath", null);
        if (event.source.getDamageType().equals("player")) {
            //ItemUtil.dropMiniumShard((EntityPlayer) event.source.getSourceOfDamage(), event.entityLiving);
        	 if (event.entityLiving instanceof IMob)
        	 {
        		 if (event.entityLiving instanceof EntitySkeleton){
        			 double rand = Math.random();
        	            rand = 0.0d;
       	            
        	            if (rand < 0.15d) {
        	            	Random rnd = new Random();
        	            	
        	            	switch (rnd.nextInt(3))
        	                {
        	                    case 0:
        	                    	event.entityLiving.dropItem(Item.emerald.itemID, 1);
        	                        break;
        	                    case 1:
        	                    	event.entityLiving.dropItem(Item.diamond.itemID, 1);
        	                        break;
        	                    case 2:
        	                    	event.entityLiving.dropItem(Item.fireballCharge.itemID, 1);
        	                }
        	            	
        	            }
        		 }
        			 
        	 }
        	 
        }
        if (event.source.getSourceOfDamage() instanceof EntityArrow) {
            if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null) {
                if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer) {
                	if (event.entityLiving instanceof IMob)
               	 {
                		if (event.entityLiving instanceof EntitySkeleton){
               			 double rand = Math.random();
               	            rand = 0.0d;
              	            
               	            if (rand < 0.15d) {
               	            	Random rnd = new Random();
               	            	
               	            	switch (rnd.nextInt(3))
               	                {
               	                    case 0:
               	                    	event.entityLiving.dropItem(Item.lightStoneDust.itemID, 1);
               	                        break;
               	                    case 1:
               	                    	event.entityLiving.dropItem(Item.redstone.itemID, 1);
               	                        break;
               	                    case 2:
               	                    	event.entityLiving.dropItem(Item.clay.itemID, 1);
               	                }
               	            	
               	            }
               		 }
               			 
               	 }
               	 
                }
            }
        }
    }

    
    
    
}
