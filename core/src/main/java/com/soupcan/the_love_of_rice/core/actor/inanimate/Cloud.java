package com.soupcan.the_love_of_rice.core.actor.inanimate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.TheLoveOfRice;
import com.soupcan.the_love_of_rice.core.manager.DebugRendererManager;
import com.soupcan.the_love_of_rice.core.manager.SpriteManager;

/**
 * Clouds go through the sky.
 *
 * @author Zachary Latta
 */
public class Cloud extends Actor
{
    public final float SPEED;

    private final Sprite sprite;
    private float screenWidth;

    public Cloud(float speed, float startingX, float startingY, float screenWidth)
    {
        setName("cloud");

        SPEED = speed;
        this.screenWidth = screenWidth;

        sprite = SpriteManager.instance.getSprite("cloud");

        setPosition(startingX, startingY);
    }

    public void move()
    {
        if(getX() > screenWidth)
        {
            setX(0 - getWidth());
        }

        setX(getX() + Gdx.graphics.getDeltaTime() * SPEED);
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {
        move();

        sprite.setPosition(getX(), getY());
        sprite.setOrigin(sprite.getX() + sprite.getWidth(), sprite.getY() + sprite.getHeight());
        sprite.setRotation(getRotation());

        setSize(sprite.getWidth(), sprite.getHeight());
        setOrigin(sprite.getOriginX(), sprite.getOriginY());

        sprite.draw(batch);

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
        renderer.setColor(new Color(Color.GREEN));
        renderer.rect(0, 0, getWidth(), getHeight());
        renderer.end();

        batch.begin();
    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
