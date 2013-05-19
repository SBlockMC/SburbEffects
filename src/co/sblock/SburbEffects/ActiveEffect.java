package co.sblock.SburbEffects;

public enum ActiveEffect {
	
	PSHOOOOT("PSHOOOOT"),	//teleport to crosshairs, may require cooldown
	BACKPACK("Backpack"), 	//mobile enderchest access
	HATGIVER("Hatgiver");	//Pop-o-matic Vrillyhoo effect: random /hat from inventory item

	private String loreText;
	private ActiveEffect(String s)	{
		loreText = s;
	}
}
