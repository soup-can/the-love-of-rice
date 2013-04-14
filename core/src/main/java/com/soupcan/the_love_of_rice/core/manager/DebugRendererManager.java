package com.soupcan.the_love_of_rice.core.manager;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.soupcan.the_love_of_rice.core.TheLoveOfRice;

/**
 * Makes getting the debug debugRenderer easy.
 *
 * @author Zachary Latta
 */
public class DebugRendererManager
{
    public static final DebugRendererManager instance = new DebugRendererManager();

    public ShapeRenderer debugRenderer;

    public DebugRendererManager()
    {
        if(TheLoveOfRice.DRAW_DEBUG)
        {
            debugRenderer = new ShapeRenderer();
        }
    }
}
