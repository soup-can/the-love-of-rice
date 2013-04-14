package com.soupcan.the_love_of_rice.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.soupcan.the_love_of_rice.core.screen.GameplayScreen;

/**
 * Start of the game!
 *
 * @author Zachary Latta
 */
public final class TheLoveOfRice extends Game
{
    public static String LOG = TheLoveOfRice.class.getSimpleName();
    public static final FPSLogger fpsLogger = new FPSLogger();

    public static TheLoveOfRice instance = new TheLoveOfRice();

    public GameplayScreen gameplayScreen;


    private TheLoveOfRice()
    {
    }

    @Override
    public void create()
    {
        gameplayScreen = new GameplayScreen();

        setScreen(gameplayScreen);
    }
}
