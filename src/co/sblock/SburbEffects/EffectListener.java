package co.sblock.SburbEffects;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class EffectListener implements Listener	{
	
	private EffectManager eM;
	
	public EffectListener(SburbEffects plugin)	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		eM = new EffectManager(plugin);
	}

	public void onPlayerLogin(PlayerLoginEvent event)	{
		Player p = event.getPlayer();
		  eM.applyEffects(eM.scan(p), p);
	}
	public void onPlayerPickupItem(PlayerPickupItemEvent event)	{
		Player p = event.getPlayer();
		eM.applyEffects(eM.scan(p), p);
	}
}
