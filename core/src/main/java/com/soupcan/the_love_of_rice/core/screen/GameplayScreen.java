package com.soupcan.the_love_of_rice.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Gameplay and stuff.
 *
 * @author Zachary Latta
 */
public class GameplayScreen implements Screen
{
    private Stage stage;

    public GameplayScreen()
    {
        stage = new Stage();
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(206f, 231f, 215f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void show()
    {
    }

    @Override
    public void hide()
    {
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public void dispose()
    {
    }
}
