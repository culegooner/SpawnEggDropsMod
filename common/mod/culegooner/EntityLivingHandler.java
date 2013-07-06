package mod.culegooner;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;




public class EntityLivingHandler {

	@ForgeSubscribe
    public void onEntityLivingDeath(LivingDeathEvent event) {
	   	if (event.source.getDamageType().equals("player")) {
          if ((event.entityLiving instanceof IAnimals)|| (event.entityLiving instanceof IMob))
        	 {
        		 //if (event.entityLiving instanceof EntitySkeleton){
        			 double rand = Math.random();
        	            rand = 0.0d;
       	            
        	            
        	            
        	            int id = EntityList.getEntityID(event.entityLiving);
        	            System.out.println("*********** onEntityLivingDeath entityID: " + id);
        	            if (id > 0 && EntityList.entityEggs.containsKey(id))
        	            {
        	                ItemStack dropEgg = new ItemStack(Item.monsterPlacer, 1, id);
        	            	event.entityLiving.entityDropItem(dropEgg, 0.0F);
        	            }
        	            
        	            
        	            
        	            /*
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
        	            */
        		 }
        			 
        	 }
        	 
        //}
        if (event.source.getSourceOfDamage() instanceof EntityArrow) {
            if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null) {
                if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer) {
                	if ((event.entityLiving instanceof IAnimals)|| (event.entityLiving instanceof IMob))
               	 {
                		//if (event.entityLiving instanceof EntitySkeleton){
               			 double rand = Math.random();
               	            rand = 0.0d;
              	            
               	         
            	            int id = EntityList.getEntityID(event.entityLiving);
            	            System.out.println("*********** onEntityLivingDeath entityID: " + id);
            	            if (id > 0 && EntityList.entityEggs.containsKey(id))
            	            {
            	                ItemStack dropEgg = new ItemStack(Item.monsterPlacer, 1, id);
            	            	event.entityLiving.entityDropItem(dropEgg, 0.0F);
            	            }
            	            
            	            /*
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
               	            */
               		                			 
               	 }
               	 
                }
            }
        }
    }

    
    
    
}
