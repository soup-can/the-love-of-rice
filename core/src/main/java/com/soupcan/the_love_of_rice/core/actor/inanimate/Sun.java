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
 * The sun provides light and warmth.
 *
 * @author Zachary Latta
 */
public class Sun extends Actor
{
    private Sprite sprite;

    private float stateTime = 0;

    public Sun()
    {
        setName("sun");
        sprite = SpriteManager.instance.getSprite("sun");
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {
        stateTime += Gdx.graphics.getDeltaTime();
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
        renderer.setColor(new Color(Color.ORANGE));
        renderer.rect(0, 0, getWidth(), getHeight());
        renderer.end();
        batch.begin();
    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
