package com.soupcan.the_love_of_rice.core.actor.animate.people;

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
        setName("farmer");

        idleAnimation = new SpriteAnimation(1f, "farmer_", 1, 2);
        harvestAnimation = new SpriteAnimation(1f, "farmer_", 1, 1);

        idleAnimation.setPlayMode(SpriteAnimation.LOOP);
        harvestAnimation.setPlayMode(SpriteAnimation.LOOP);

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
