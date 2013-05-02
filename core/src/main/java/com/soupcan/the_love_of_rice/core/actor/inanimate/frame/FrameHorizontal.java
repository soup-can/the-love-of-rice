package com.soupcan.the_love_of_rice.core.actor.inanimate.frame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.manager.SpriteManager;

/**
 * A horizontal strip of the frame. Kill me for being inefficient.
 *
 * @author Zachary Latta
 */
public class FrameHorizontal extends Actor
{
    private Sprite sprite;

    public FrameHorizontal()
    {
        sprite = SpriteManager.instance.getSprite("frame_horizontal");
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {
        sprite.setPosition(getX(), getY());
        sprite.setOrigin(sprite.getX() + sprite.getWidth(), sprite.getY() + sprite.getHeight());
        sprite.setRotation(getRotation());
        setSize(sprite.getWidth(), sprite.getHeight());
        setOrigin(sprite.getOriginX(), sprite.getOriginY());
        sprite.draw(batch);
    }
}
