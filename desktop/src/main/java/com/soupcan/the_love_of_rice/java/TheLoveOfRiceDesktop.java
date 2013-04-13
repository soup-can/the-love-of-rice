package com.soupcan.the_love_of_rice.java;

import com.soupcan.the_love_of_rice.core.TheLoveOfRice;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class TheLoveOfRiceDesktop
{
	public static void main(String[] args)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
		new LwjglApplication(TheLoveOfRice.instance, config);
	}
}
