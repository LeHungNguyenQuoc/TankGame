package com.product.game.tankbattle.actor.sprite;

public class ControllerResourceInfo {
	public DPADResourceInfo dPad;
	public FireButtonResoureInfo fireButton;
	
	public ControllerResourceInfo() {
		dPad = new DPADResourceInfo();
		fireButton = new FireButtonResoureInfo();
	}
}
