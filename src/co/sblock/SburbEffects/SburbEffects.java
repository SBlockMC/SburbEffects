package co.sblock.SburbEffects;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class SburbEffects extends JavaPlugin	{

	@Override
	public void onEnable()	{
		
	}
	
	@Override
	public void onDisable()	{
		
	}
	
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args)	{
		Player p = (Player) sender;
		ArrayList<String> lore = new ArrayList<String>();
		if (cmd.getName().equalsIgnoreCase("se"))	{
			if (sender instanceof Player && sender.isOp())	{
				if(args[0].equalsIgnoreCase("getlore"))	{
					if(p.getItemInHand().getItemMeta().hasLore())	{
						lore = (ArrayList<String>) p.getItemInHand().getItemMeta().getLore();
						p.sendMessage(lore.toString());
						return true;
					}
				}
				else if(args[0].equalsIgnoreCase("setlore") && !(args[1].equals(null)))	{
					ItemMeta i = p.getItemInHand().getItemMeta();
					lore.add(args[1]);
					i.setLore(lore);
					p.getItemInHand().setItemMeta(i);
					return true;
				}
			}	
		}
		return false;
	}
}
