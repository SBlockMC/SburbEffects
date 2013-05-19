package co.sblock.SburbEffects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum PassiveEffect {
	
	JUMP("Jump"),
	SPEED("Speed"),
	FLOWERS("Flowers");
	
	private String loreText;
	private PassiveEffect(String s)	{
		loreText = s;
	}
	
	public String getLoreText()	{
		return this.loreText;
	}
	
	public void applyEffect(PassiveEffect e, Player p)	{
		PotionEffect potEffect;
		switch (e)	{
		
		case JUMP:
			potEffect = new PotionEffect(PotionEffectType.JUMP, 1200, 1);
			p.addPotionEffect(potEffect);
			break;
		case SPEED:
			potEffect = new PotionEffect(PotionEffectType.SPEED, 1200, 1);
			p.addPotionEffect(potEffect);
			break;
		default:
			break;
			
		}
	}
}
