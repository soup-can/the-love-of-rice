package com.soupcan.the_love_of_rice.android;

import com.soupcan.the_love_of_rice.core.TheLoveOfRice;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class TheLoveOfRiceActivity extends AndroidApplication
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGL20 = true;
        initialize(TheLoveOfRice.instance, config);
    }
}
