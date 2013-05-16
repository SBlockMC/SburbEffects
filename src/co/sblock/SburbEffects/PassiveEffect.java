package co.sblock.SburbEffects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public enum PassiveEffect {
	
	JUMP,
	SPEED,
	FLOWERS;
	
	public void getEffect(PassiveEffect e, Player p)	{
		switch (e)	{
		
		case JUMP:
			PotionEffect potEffect = new PotionEffect(type, duration, amplifier)
			p.addPotionEffect(effect)
		}
	}
}
