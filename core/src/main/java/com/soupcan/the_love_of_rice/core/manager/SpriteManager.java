package com.soupcan.the_love_of_rice.core.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

/**
 * Manages sprites. Loads them from a file and stores them in an array.
 *
 * @author Zachary Latta
 */
public class SpriteManager
{
    public static SpriteManager instance = new SpriteManager();

    private TextureAtlas atlas = null;
    private HashMap<String, Sprite> sprites = null;

    private SpriteManager()
    {
        atlas = new TextureAtlas(Gdx.files.internal("img/sprites.pack"));
        sprites = new HashMap<String, Sprite>();
        load();
    }

    private void load()
    {
        assert sprites != null && atlas != null;
        Array<Sprite> createdSprites = atlas.createSprites();
        Array<TextureAtlas.AtlasRegion> atlasRegions = atlas.getRegions();

        for(int i = 0; i < createdSprites.size && i < atlasRegions.size; i++)
        {
            TextureAtlas.AtlasRegion currentRegion = atlasRegions.get(i);

            // If it's a sequence of images, then include the index in the sprite
            // name when putting it in the HashMap.
            if(atlasRegions.get(i).index != -1)
            {
                sprites.put(currentRegion.name + "_" + currentRegion.index, createdSprites.get(i));
            }

            else
            {
                sprites.put(atlasRegions.get(i).name, createdSprites.get(i));
            }
        }
    }

    public Sprite getSprite(String name)
    {
        Sprite toReturn = sprites.get(name);
        return toReturn;
    }
}
