package co.sblock.SburbEffects;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EffectListener implements Listener	{

	public void onPlayerLogin(PlayerLoginEvent event)	{
		this.scan(event.getPlayer());
	}
	public void onPlayerPickupItem(PlayerPickupItemEvent event)	{
		this.scan(event.getPlayer());
	}
	
	public ArrayList<String> scan(Player p)	{
		PlayerInventory pInv = p.getInventory();
		ItemStack[] iS = pInv.getContents();
		ArrayList<String> playerLore = new ArrayList<String>();
		for(ItemStack i : iS)	{
			if(i.getItemMeta().hasLore())	{
				playerLore.addAll(i.getItemMeta().getLore());
			}
		}
		for(String s: playerLore)	{
			boolean isValidLore = false;
			for(PassiveEffect pE : PassiveEffect.values())	{
				isValidLore = pE.getLoreText().equalsIgnoreCase(s);				
			}
			if(!isValidLore)	{
				playerLore.remove(playerLore.indexOf(s));
			}
		}
		return playerLore;
	}
}
