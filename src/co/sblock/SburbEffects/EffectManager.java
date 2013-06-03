package co.sblock.SburbEffects;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class EffectManager {

	private final JavaPlugin plugin;
	
	public EffectManager(JavaPlugin pl) {
		plugin = pl;
	}

	public ArrayList<String> scan(Player p)	{
		PlayerInventory pInv = p.getInventory();
		ItemStack[] iS = pInv.getContents();
		ArrayList<String> playerLore = new ArrayList<String>();
		ArrayList<String> tempLore = new ArrayList<String>();
		for(ItemStack i : iS)	{
			try {
				//System.out.println(i.getType().toString());
				if(i.hasItemMeta() && i.getItemMeta().hasLore())	{
					tempLore.addAll(i.getItemMeta().getLore());
					playerLore.addAll(i.getItemMeta().getLore());
				}
			} catch (NullPointerException e) {	//Catches empty inventory slots
			}
		}
		for(String s: tempLore)	{
			try {
				PassiveEffect pE = PassiveEffect.valueOf(s);
			} catch (IllegalArgumentException e) {
				//p.sendMessage(s);
				playerLore.remove(playerLore.indexOf(s));
			}
		}
		plugin.getLogger().info(p.getName() + playerLore);
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
