package com.soupcan.the_love_of_rice.core.screen;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.actor.inanimate.Cloud;
import com.soupcan.the_love_of_rice.core.actor.inanimate.Fence;
import com.soupcan.the_love_of_rice.core.actor.inanimate.Sun;
import com.soupcan.the_love_of_rice.core.actor.animate.people.Farmer;
import com.soupcan.the_love_of_rice.core.actor.animate.people.Ninja;
import com.soupcan.the_love_of_rice.core.actor.animate.people.Samurai;
import com.soupcan.the_love_of_rice.core.actor.animate.people.Sumo;

import java.util.ArrayList;
import java.util.List;

/**
 * Gameplay and stuff.
 *
 * @author Zachary Latta
 */
public class GameplayScreen extends AbstractScreen
{
    public static final int CLOUD_COUNT = 3;

    private List<Actor> clouds = new ArrayList<Actor>();
    Actor sun = new Sun();
    Actor farmer = new Farmer();
    Actor farmer2 = new Farmer();
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
        farmer2.setX(170);
        ninja.setX(50);
        sumo.setX(100);
        samurai.setX(150);
        fence.setX(0);

        stage.addActor(sun);

        for(int i = 0; i < CLOUD_COUNT; i++)
        {
            clouds.add(new Cloud(MathUtils.random(10), MathUtils.random(stage.getWidth()), MathUtils.random(80, 100),
                    stage.getWidth()));
            stage.addActor(clouds.get(i));
        }

        stage.addActor(farmer);
        stage.addActor(farmer2);
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
