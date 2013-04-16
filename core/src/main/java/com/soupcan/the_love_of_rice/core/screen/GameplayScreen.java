package com.soupcan.the_love_of_rice.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.soupcan.the_love_of_rice.core.actor.animate.farm.PaddyField;
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
    public static final int FENCE_COUNT = 30;

    private List<Actor> clouds = new ArrayList<Actor>();
    private List<Actor> fences = new ArrayList<Actor>();
    Actor sun = new Sun();
    Actor farmer = new Farmer();
    Actor farmer2 = new Farmer();
    Actor ninja = new Ninja();
    Actor sumo = new Sumo();
    Actor samurai = new Samurai();
    Actor ricePaddy = new PaddyField();
    Actor ricePaddy2 = new PaddyField();

    public GameplayScreen()
    {
        super();

        sun.setPosition(175f, 100f);
        ricePaddy.setX(125);
        ricePaddy2.setX(50);
        farmer.setX(40);
        farmer2.setX(110);
        ninja.setX(180);
        sumo.setX(160);
        samurai.setX(70);

        stage.addActor(sun);

        for(int i = 0; i < CLOUD_COUNT; i++)
        {
            clouds.add(new Cloud(MathUtils.random(10), MathUtils.random(stage.getWidth()), MathUtils.random(90, 110),
                    stage.getWidth()));
            stage.addActor(clouds.get(i));
        }


        float xCount = 0;
        for(int i = 0; i < FENCE_COUNT; i++)
        {
            fences.add(new Fence(stage.getWidth()));

            fences.get(i).setX(xCount);
            xCount += fences.get(i).getWidth();

            stage.addActor(fences.get(i));
        }

        stage.addActor(ricePaddy);
        stage.addActor(ricePaddy2);
        stage.addActor(farmer);
        stage.addActor(farmer2);
        stage.addActor(sumo);
        stage.addActor(samurai);
        stage.addActor(ninja);

        for(final Actor actor : stage.getActors())
        {
            actor.addListener(new InputListener()
            {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
                {
                    Gdx.app.log(getName(), "User touched " + actor.getName() + " at (" + x + ", " + y + ")");

                    return true;
                }

                public void touchUp(InputEvent event, float x, float y, int pointer, int button)
                {
                    Gdx.app.log(getName(), "User released " + actor.getName() + " at (" + x + ", " + y + ")");

                    MoveToAction action = new MoveToAction();
                    // Sets position so that the middle of the actor ends up on the mouse when the user releases.
                    action.setPosition(x + actor.getX() - actor.getWidth() / 2,
                                       y + actor.getY() - actor.getHeight() / 2);
                    action.setDuration(1);
                    action.setInterpolation(Interpolation.exp5);
                    actor.addAction(action);
                }
            });
        }
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
