package com.product.game.tankbattle.controller;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.algorithm.path.Path;

import android.util.Log;

public class DPadSprite extends AnimatedSprite{

	public DPadSprite(float pX, float pY,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager vertexBufferObjectManager) {
		super(pX, pY, pTiledTextureRegion, vertexBufferObjectManager);
		isHolding = false;
	}

	public interface IDPadSpriteListener {
		public void touchUp();
		public void touchDown();
		public void touchLeft();
		public void touchRight();
		
		public void noTouch();
	}
	
	private IDPadSpriteListener _touchListener;
	private boolean isHolding;
	
	public void registerListener(IDPadSpriteListener listener) {
		_touchListener = listener;
	}
	
	
	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
		 if (pSceneTouchEvent.isActionDown()){
			 isHolding = true;
	     } else if (pSceneTouchEvent.isActionUp()) {
			isHolding = false;
	     }

		this.doCheckTouchPart((int)pTouchAreaLocalX, (int)pTouchAreaLocalY);
		return true;
	}
	
	
	private void doCheckTouchPart(int pointX, int pointY) {	
		if (_touchListener == null) {
			return;
		}
		if (!isHolding) {
			_touchListener.noTouch();
		} else {
			if (onLeftPart(pointX, pointY)) {
				_touchListener.touchLeft();
			} else if (onRightPart(pointX, pointY)) {
				_touchListener.touchRight();
			} else if (onUpPart(pointX, pointY)) {
				_touchListener.touchUp();
			} else if (onDownPart(pointX, pointY)) {
				_touchListener.touchDown();
			} 
		}
	}
	
	
	private boolean onLeftPart(int pointX, int poinY) {
		Path trianglePath = new Path(3);
		trianglePath.set(0, 0, 0);
		trianglePath.set(1, 0, (int)getHeight());
		trianglePath.set(2, (int)getWidth()/2, (int)getHeight()/2);
		
		return trianglePath.contains(pointX, poinY);
		
	}
	
	private boolean onRightPart(int pointX, int poinY) {
		Path trianglePath = new Path(3);
		trianglePath.set(0, (int)getWidth(), 0);
		trianglePath.set(1, (int)getWidth(), (int)getHeight());
		trianglePath.set(2, (int)getWidth()/2, (int)getHeight()/2);
		
		return trianglePath.contains(pointX, poinY);
		
	}
	
	private boolean onUpPart(int pointX, int poinY) {
		Path trianglePath = new Path(3);
		trianglePath.set(0, 0, 0);
		trianglePath.set(1, (int)getWidth(), 0);
		trianglePath.set(2, (int)getWidth()/2, (int)getHeight()/2);
		
		return trianglePath.contains(pointX, poinY);
		
	}
	
	private boolean onDownPart(int pointX, int poinY) {
		Path trianglePath = new Path(3);
		trianglePath.set(0, 0, (int)getHeight());
		trianglePath.set(1, (int)getWidth(), (int)getHeight());
		trianglePath.set(2, (int)getWidth()/2, (int)getHeight()/2);
		
		return trianglePath.contains(pointX, poinY);
		
	}

}
