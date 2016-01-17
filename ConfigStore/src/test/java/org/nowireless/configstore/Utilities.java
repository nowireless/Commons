package org.nowireless.configstore;

import com.google.gson.GsonBuilder;

public class Utilities {
	public static GsonBuilder getGsonBuilder() {
		return new GsonBuilder().setPrettyPrinting();
	}
}
