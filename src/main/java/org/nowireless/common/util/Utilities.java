package org.nowireless.common.util;

import com.google.gson.GsonBuilder;

public class Utilities {
	public static GsonBuilder getGsonBuilder() {
		return new GsonBuilder().setPrettyPrinting();
	}
}
