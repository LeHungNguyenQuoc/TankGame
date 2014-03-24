package com.product.game.tankbattle.resource.sprite;

public class ControllerSpriteManager {
	public DpadSpriteManager dPad;
	public ButtonSpriteManager fireButton;
	
	public ControllerSpriteManager() {
		dPad = new DpadSpriteManager();
		fireButton = new ButtonSpriteManager();
	}
}
