package co.sblock.SburbEffects;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class SburbEffects extends JavaPlugin	{
	
	private EffectListener eL;
	private EffectManager eM;
	private BukkitTask task;

	@Override
	public void onEnable()	{
		eL = new EffectListener(this);
		eM = new EffectManager(this);
		task = new EffectScheduler(this).runTaskTimer(this, 0, 1200);
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
					p.sendMessage("Item has no lore!");
					return true;
				}
				else if(args[0].equalsIgnoreCase("setlore") && !(args[1].equals(null)))	{
					ItemMeta i = p.getItemInHand().getItemMeta();
					if(i.hasLore())	{
						lore.addAll(i.getLore());
					}
					lore.add(args[1]);
					i.setLore(lore);
					p.getItemInHand().setItemMeta(i);
					return true;
				}
				else if(args[0].equalsIgnoreCase("applyeffects") && !(args[1].equals(null)))	{
					Player target = this.getServer().getPlayer(args[1]);
					//getLogger().info("Begin Scan");
					ArrayList<String> playerLore = eM.scan(target);
					//getLogger().info(target + "'s lore is " + playerLore);
					p.sendMessage(target.getName() + playerLore);
					//getLogger().info("Begin Application");
					eM.applyEffects(playerLore, target);
					return true;
				}
			}	
		}
		return false;
	}
}
