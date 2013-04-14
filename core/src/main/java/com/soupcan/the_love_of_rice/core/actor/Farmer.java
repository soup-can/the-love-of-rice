package com.soupcan.the_love_of_rice.core.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.image.SpriteAnimation;

/**
 * Farmers farm rice paddies.
 *
 * @author Zachary Latta
 */
public class Farmer extends Actor
{
    private SpriteAnimation currentAnimation = null;
    private SpriteAnimation idleAnimation = null;
    private SpriteAnimation harvestAnimation = null;

    private float stateTime = 0;

    public Farmer()
    {
        idleAnimation = new SpriteAnimation(1f, "farmer_", 1, 2);
        harvestAnimation = new SpriteAnimation(1f, "farmer_", 1, 1);

        idleAnimation.setPlayMode(SpriteAnimation.LOOP);
        harvestAnimation.setPlayMode(SpriteAnimation.LOOP);

        currentAnimation = idleAnimation;

        scale(2);
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {
        stateTime += Gdx.graphics.getDeltaTime();

        Sprite toRender = currentAnimation.getKeyFrame(stateTime);
        toRender.setScale(getScaleX(), getScaleY());
        toRender.setOrigin(getX(), getY());
        toRender.setPosition(getX(), getY());

        toRender.draw(batch);
    }
}
