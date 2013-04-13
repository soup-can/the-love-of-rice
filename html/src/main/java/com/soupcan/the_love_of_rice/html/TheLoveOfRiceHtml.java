package com.soupcan.the_love_of_rice.html;

import com.soupcan.the_love_of_rice.core.TheLoveOfRice;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class TheLoveOfRiceHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new TheLoveOfRice();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
