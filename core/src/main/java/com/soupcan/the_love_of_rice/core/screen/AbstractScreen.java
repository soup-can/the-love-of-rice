package com.soupcan.the_love_of_rice.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.soupcan.the_love_of_rice.core.TheLoveOfRice;

/**
 * Other screens extend this.
 *
 * @author Zachary Latta
 */
public abstract class AbstractScreen implements Screen
{
    protected final SpriteBatch batch;
    protected final Stage stage;

    public AbstractScreen()
    {
        this.batch = new SpriteBatch();
        this.stage = new Stage((1280 - 96) / 5, 768 / 5, false);
        Gdx.input.setInputProcessor(stage);
    }

    protected String getName()
    {
        return this.getClass().getSimpleName();
    }

    @Override
    public void show()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Showing screen: " + getName());
    }

    @Override
    public void resize(int width, int height)
    {
        stage.setViewport((1280 - 96) / 5, 768 / 5, false);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.8078431373f, 0.9058823529f, 0.8431372549f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Log dat FPS
        TheLoveOfRice.fpsLogger.log();
        // Update and draw the stage actor
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Hiding screen: " + getName());
    }

    @Override
    public void pause()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Pausing screen: " + getName());
    }

    @Override
    public void resume()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Resuming screen: " + getName());
    }

    @Override
    public void dispose()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Disposing screen: " + getName());
        stage.dispose();
        batch.dispose();
    }
}
