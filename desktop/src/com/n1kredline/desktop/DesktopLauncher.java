package com.n1kredline.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.n1kredline.MegaItineraryGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Itinerary";
		config.width = 480;
		config.height = 800;
		new LwjglApplication(new MegaItineraryGame(), config);
	}
}