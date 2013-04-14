package com.soupcan.the_love_of_rice.core.actor.people;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.TheLoveOfRice;
import com.soupcan.the_love_of_rice.core.image.SpriteAnimation;
import com.soupcan.the_love_of_rice.core.manager.DebugRendererManager;

/**
 * Sumos block Ninjas.
 *
 * @author Zachary Latta
 */
public class Sumo extends Actor
{
    private SpriteAnimation currentAnimation = null;
    private SpriteAnimation idleAnimation = null;
    private SpriteAnimation hurtAnimation = null;

    private float stateTime = 0;

    public Sumo()
    {
        idleAnimation = new SpriteAnimation(1f, "sumo_", 1, 2);
        hurtAnimation = new SpriteAnimation(1f, "sumo_hurt_", 1, 2);

        idleAnimation.setPlayMode(SpriteAnimation.LOOP);
        hurtAnimation.setPlayMode(SpriteAnimation.LOOP);

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

        if(TheLoveOfRice.DRAW_DEBUG)
        {
            drawDebug(batch);
        }
    }

    public void drawDebug(SpriteBatch batch)
    {
        batch.end();

        ShapeRenderer renderer = DebugRendererManager.instance.debugRenderer;

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(new Color(Color.RED));
        renderer.rect(0, 0, getWidth(), getHeight());
        renderer.end();

        batch.begin();
    }
}
