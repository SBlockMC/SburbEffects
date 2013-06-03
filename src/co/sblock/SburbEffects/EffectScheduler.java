package co.sblock.SburbEffects;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EffectScheduler extends BukkitRunnable {
	
	private final JavaPlugin plugin;
	private EffectManager eM;

	public EffectScheduler(JavaPlugin pl)	{
		plugin = pl;
		eM = new EffectManager(plugin);
	}
	
	@Override
	public void run() {
		plugin.getLogger().info("Effect Tick");
		for(Player p : plugin.getServer().getOnlinePlayers())	{
			eM.applyEffects(eM.scan(p), p);
			
		}		
	}
}
