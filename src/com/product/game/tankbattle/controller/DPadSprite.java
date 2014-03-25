package com.product.game.tankbattle.controller;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.algorithm.path.Path;

import android.graphics.Point;
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
		return false;
	}
	
	
	private void doCheckTouchPart(float pointX, float pointY) {	
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
	
	
	private boolean onLeftPart(float pointX, float poinY) {
		
		LocalPoint touchPoint = new LocalPoint(pointX, poinY);
		LocalPoint pA = new LocalPoint(0, 0); 
		LocalPoint pB = new LocalPoint(0, getHeight());
		LocalPoint pC = new LocalPoint(getWidth()/2, getHeight()/2);
		return isContaint(touchPoint, new LocalPoint [] {pA, pB, pC});
		
	}
	
	private boolean onRightPart(float pointX, float poinY) {
		
		LocalPoint touchPoint = new LocalPoint(pointX, poinY);
		LocalPoint pA = new LocalPoint(getWidth(), 0);
		LocalPoint pB = new LocalPoint(getWidth(), getHeight());
		LocalPoint pC = new LocalPoint(getWidth()/2, getHeight()/2);
		return isContaint(touchPoint, new LocalPoint [] {pA, pB, pC});		
	}
	
	private boolean onUpPart(float pointX, float poinY) {
		
		LocalPoint touchPoint = new LocalPoint(pointX, poinY);
		LocalPoint pA = new LocalPoint(0, 0);
		LocalPoint pB = new LocalPoint(getWidth(), 0);
		LocalPoint pC = new LocalPoint(getWidth()/2, getHeight()/2);
		return isContaint(touchPoint, new LocalPoint [] {pA, pB, pC});	
		
	}
	
	private boolean onDownPart(float pointX, float poinY) {

		LocalPoint touchPoint = new LocalPoint(pointX, poinY);
		LocalPoint pA = new LocalPoint(0, getHeight());
		LocalPoint pB = new LocalPoint(getWidth(), getHeight());
		LocalPoint pC = new LocalPoint(getWidth()/2, getHeight()/2);
		return isContaint(touchPoint, new LocalPoint [] {pA, pB, pC});		}
	
	
	public boolean isContaint(LocalPoint test, LocalPoint[]polygon) {
		int i;
		int j;
		boolean result = false;
		for (i = 0, j = polygon.length - 1; i < polygon.length; j = i++) {
			if ((polygon[i].y > test.y) != (polygon[j].y > test.y) &&
					(test.x < (polygon[j].x - polygon[i].x) * (test.y - polygon[i].y) / (polygon[j].y-polygon[i].y) + polygon[i].x)) {
				result = !result;
			}
		}
		return result;
	}
	
	
	class LocalPoint {
		public LocalPoint(float x, float y) {
			this.x = x;
			this.y = y;
		}
		public float x;
		public float y;
		
	}

}