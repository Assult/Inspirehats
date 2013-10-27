package me.inspire.hat;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener{
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(InventoryClickEvent e){
		
		if(e.getSlotType() == SlotType.ARMOR){
			 if(e.getSlot() == 39){
			 e.setCancelled(true);
		}
		}
		
		
			
		
	}

}
