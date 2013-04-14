package com.soupcan.the_love_of_rice.core.actor.inanimate.frame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.manager.SpriteManager;

/**
 * The bottom right corner of the frame. Kill me for being inefficient.
 *
 * @author Zachary Latta
 */
public class FrameBottomRight extends Actor
{
    private Sprite sprite;

    public FrameBottomRight()
    {
        sprite = SpriteManager.instance.getSprite("frame_bot_r");
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
