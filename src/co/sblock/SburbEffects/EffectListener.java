package co.sblock.SburbEffects;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EffectListener implements Listener	{
	
	public EffectListener(SburbEffects plugin)	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public void onPlayerLogin(PlayerLoginEvent event)	{
		Player p = event.getPlayer();
		this.applyEffects(scan(p), p);
	}
	public void onPlayerPickupItem(PlayerPickupItemEvent event)	{
		Player p = event.getPlayer();
		this.applyEffects(scan(p), p);
	}
	
	public ArrayList<String> scan(Player p)	{
		PlayerInventory pInv = p.getInventory();
		ItemStack[] iS = pInv.getContents();
		ArrayList<String> playerLore = new ArrayList<String>();
		for(ItemStack i : iS)	{
			try {
				System.out.println(i.getType().toString());
				if(i.hasItemMeta() && i.getItemMeta().hasLore())	{
					playerLore.addAll(i.getItemMeta().getLore());
				}
			} catch (NullPointerException e) {
		
			}
		}
		try {
			for(String s: playerLore)	{
				try {
					PassiveEffect pE = PassiveEffect.valueOf(s);
				} catch (IllegalArgumentException e) {
					p.sendMessage(s);
					playerLore.remove(playerLore.indexOf(s));
				}
			}
		} catch (ConcurrentModificationException e) {

		}
		return playerLore;
	}
	
	public void applyEffects(ArrayList<String> effects, Player p)	{
		for(String lore : effects)	{
			try {
				PassiveEffect pE = PassiveEffect.valueOf(lore);
				pE.getEffect(pE, p);
			} catch (IllegalArgumentException e) {

			}
		}
	}
}
