package com.soupcan.the_love_of_rice.core.image;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.soupcan.the_love_of_rice.core.manager.SpriteManager;

/**
 * Makes animating sprites easy.
 *
 * @author Zachary Latta
 */
public class SpriteAnimation
{
    public static final int NORMAL = 0;
    public static final int REVERSED = 1;
    public static final int LOOP = 2;
    public static final int LOOP_REVERSED = 3;
    public static final int LOOP_PINGPONG = 4;
    public static final int LOOP_RANDOM = 5;

    public final float frameDuration;
    public final float animationDuration;

    private Array<Sprite> sprites;

    private int playMode = NORMAL;

    public SpriteAnimation(float frameDuration, Array<String> names)
    {
        for(String name : names)
        {
            sprites.add(SpriteManager.instance.getSprite(name));
        }

        this.frameDuration = frameDuration;
        this.animationDuration = sprites.size * frameDuration;
    }

    public SpriteAnimation(float frameDuration, String prefix, int first, int last)
    {
        for(int i = first; i < last; i++)
        {
            String name = prefix + Integer.toString(i);
            sprites.add(SpriteManager.instance.getSprite(name));
        }

        this.frameDuration = frameDuration;
        this.animationDuration = sprites.size * frameDuration;
    }

    public Sprite getKeyFrame(float stateTime, boolean looping)
    {
        // We set the play mode by overriding the previous mode based on looping
        // parameter value
        if (looping && (playMode == NORMAL || playMode == REVERSED))
        {
            if (playMode == NORMAL)
            {
                playMode = LOOP;
            }
            else
            {
                playMode = LOOP_REVERSED;
            }
        }
        else if (!looping && !(playMode == NORMAL || playMode == REVERSED))
        {
            if (playMode == LOOP_REVERSED)
            {
                playMode = REVERSED;
            }
            else
            {
                playMode = LOOP;
            }
        }

        return getKeyFrame(stateTime);
    }

    /**
     * Returns a {@link Sprite} based on the so called state time. This is the amount of seconds an object has spent in the
     * state this Animation instance represents, e.g. running, jumping and so on using the mode specified by
     * {@link #setPlayMode(int)} method.
     *
     * @param stateTime
     * @return the Sprite representing the frame of animation for the given state time.
     */
    public Sprite getKeyFrame(float stateTime)
    {
        int frameNumber = getKeyFrameIndex(stateTime);
        return sprites.get(frameNumber);
    }

    /** Returns the current frame number.
     * @param stateTime
     * @return current frame number */
    public int getKeyFrameIndex(float stateTime) {
        int frameNumber = (int)(stateTime / frameDuration);

        if(sprites.size == 1)
        {
            return 0;
        }

        switch(playMode)
        {
            case NORMAL:
                frameNumber = Math.min(sprites.size - 1, frameNumber);
                break;
            case LOOP:
                frameNumber = frameNumber % sprites.size;
                break;
            case LOOP_PINGPONG:
                frameNumber = frameNumber % ((sprites.size * 2) - 2);
                if (frameNumber >= sprites.size)
                {
                    frameNumber = sprites.size - 2 - (frameNumber - sprites.size);
                }
                break;
            case LOOP_RANDOM:
                frameNumber = MathUtils.random(sprites.size - 1);
                break;
            case REVERSED:
                frameNumber = Math.max(sprites.size - frameNumber - 1, 0);
                break;
            case LOOP_REVERSED:
                frameNumber = frameNumber % sprites.size;
                frameNumber = sprites.size - frameNumber - 1;
                break;

            default:
                // Play normal otherwise
                frameNumber = Math.min(sprites.size - 1, frameNumber);
                break;
        }

        return frameNumber;
    }

    /**
     * Sets the animation play mode.
     *
     * @param playMode can be one of the following: SpriteAnimation.NORMAL, SpriteAnimation.REVERSED,
     *                 SpriteAnimation.LOOP, SpriteAnimation.LOOP_REVERSED, SpriteAnimation.LOOP_PINGPONG,
     *                 SpriteAnimation.LOOP_RANDOM
     */
    public void setPlayMode(int playMode)
    {
        this.playMode = playMode;
    }

    /**
     * Whether the animation would be finished if played without looping (PlayMode SpriteAnimation#NORMAL), given the
     * state time.
     *
     * @param stateTime
     * @return whether the animation is finished.
     */
    public boolean isAnimationFinished(float stateTime)
    {
        int frameNumber = (int)(stateTime / frameDuration);
        return sprites.size - 1 < frameNumber;
    }
}
