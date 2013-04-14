package com.soupcan.the_love_of_rice.core.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.actor.inanimate.Fence;
import com.soupcan.the_love_of_rice.core.actor.inanimate.Sun;
import com.soupcan.the_love_of_rice.core.actor.people.Farmer;
import com.soupcan.the_love_of_rice.core.actor.people.Ninja;
import com.soupcan.the_love_of_rice.core.actor.people.Samurai;
import com.soupcan.the_love_of_rice.core.actor.people.Sumo;

/**
 * Gameplay and stuff.
 *
 * @author Zachary Latta
 */
public class GameplayScreen extends AbstractScreen
{
    Actor sun = new Sun();
    Actor farmer = new Farmer();
    Actor ninja = new Ninja();
    Actor sumo = new Sumo();
    Actor samurai = new Samurai();
    Actor fence;

    public GameplayScreen()
    {
        super();

        fence = new Fence(stage.getWidth());

        sun.setPosition(206, 84.4f);
        farmer.setX(10);
        ninja.setX(50);
        sumo.setX(100);
        samurai.setX(150);
        fence.setX(0);

        stage.addActor(sun);
        stage.addActor(farmer);
        stage.addActor(ninja);
        stage.addActor(sumo);
        stage.addActor(samurai);
        stage.addActor(fence);
    }

    @Override
    public void render(float delta)
    {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
    }

    @Override
    public void show()
    {
        super.show();
    }

    @Override
    public void hide()
    {
        super.hide();
    }

    @Override
    public void pause()
    {
        super.pause();
    }

    @Override
    public void resume()
    {
        super.resume();
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
