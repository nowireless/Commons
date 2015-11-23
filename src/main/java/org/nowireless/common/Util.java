package org.nowireless.common;

import com.google.gson.GsonBuilder;

public class Util {
	public static GsonBuilder getGsonBuilder() {
		return new GsonBuilder().setPrettyPrinting();
	}
}
