package bacon;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class EventHooks {
	public static double rand;
	   
	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.entityLiving instanceof EntityPig){
			rand = Math.random();
			if (rand < 0.3D) {
				if(event.source == DamageSource.inFire || event.source == DamageSource.onFire || event.source == DamageSource.lava){
					event.entityLiving.dropItem(BaconMain.baconCooked.itemID, 1);
				} else {					
					event.entityLiving.dropItem(BaconMain.baconRaw.itemID, 1);
				}
			}
		}
	}
    
	@ForgeSubscribe
	public void PickUpBacon(EntityItemPickupEvent event) {
		EntityItem item = event.item;
		EntityPlayer player = event.entityPlayer;
		String pickedUp = item.getEntityItem().getUnlocalizedName();
		if (pickedUp.contains("item.baconRaw")) {
			player.addStat(BaconMain.bringBacon, 1);
		}
		// TODO Auto-generated constructor stub
	}

}
