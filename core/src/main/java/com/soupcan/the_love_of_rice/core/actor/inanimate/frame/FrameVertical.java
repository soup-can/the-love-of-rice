package com.soupcan.the_love_of_rice.core.actor.inanimate.frame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.manager.SpriteManager;

/**
 * A vertical strip of the frame. Kill me for being inefficient.
 *
 * @author Zachary Latta
 */
public class FrameVertical extends Actor
{
    private Sprite sprite;

    public FrameVertical()
    {
        sprite = SpriteManager.instance.getSprite("frame_vertical");
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {

    }
}
