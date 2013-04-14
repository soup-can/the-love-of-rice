package com.soupcan.the_love_of_rice.core.actor.people;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.image.SpriteAnimation;

/**
 * Sumos block Ninjas.
 *
 * @author Zachary Latta
 */
public class Sumo extends Actor
{
    private SpriteAnimation currentAnimation = null;
    private SpriteAnimation idleAnimation = null;
    private SpriteAnimation blockAnimation = null;

    private float stateTime = 0;

    public Sumo()
    {
        idleAnimation = new SpriteAnimation(1f, "sumo_", 1, 2);
        blockAnimation = new SpriteAnimation(1f, "sumo_", 1, 1);

        idleAnimation.setPlayMode(SpriteAnimation.LOOP);
        blockAnimation.setPlayMode(SpriteAnimation.LOOP);

        currentAnimation = idleAnimation;
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {
        stateTime += Gdx.graphics.getDeltaTime();

        Sprite toRender = currentAnimation.getKeyFrame(stateTime);

        toRender.setPosition(getX(), getY());
        toRender.setOrigin(toRender.getX() + toRender.getWidth(), toRender.getY() + toRender.getHeight());
        toRender.setRotation(getRotation());

        setSize(toRender.getWidth(), toRender.getHeight());
        setOrigin(toRender.getOriginX(), toRender.getOriginY());

        toRender.draw(batch);
    }
}
