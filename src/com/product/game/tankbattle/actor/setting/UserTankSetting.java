package com.product.game.tankbattle.actor.setting;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TEAM;
import com.product.game.tankbattle.actor.sprite.BaseSpriteResourceInfo;
import com.product.game.tankbattle.actor.sprite.TankResourcesInfo;
import com.product.game.tankbattle.config.GameResource;

public class UserTankSetting implements TankSetting {
	
	final static int HIT_POINT = 1;
	final static float SPEED = 500;
	final static int STEP_DISTANCE = 10;
	final static int TANK_LEVEL = 1;
	
	@Override
	public int getHitPoint() {
		return HIT_POINT;
	}

	@Override
	public float getSpeed() {
		return SPEED;
	}

	@Override
	public int getLevel() {
		return TANK_LEVEL;
	}

	@Override
	public IEntity getEngineEntity() {
		return GameResource.getInstance().tankResources.makeAnimateSprite();
	}

	@Override
	public ACTOR_TEAM getTeam() {
		return ACTOR_TEAM.User;
	}

	@Override
	public int getStepDistance() {
		return STEP_DISTANCE;
	}

	@Override
	public BaseSpriteResourceInfo getSpriteResourceInfo() {
		return GameResource.getInstance().tankResources;
	}

}
