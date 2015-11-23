package org.nowireless.configstore;

import java.io.File;

import org.nowireless.common.Util;
import org.nowireless.mstore.MStore;
import org.nowireless.mstore.MStoreUser;

import com.google.gson.Gson;

public class ConfigStoreTest implements MStoreUser {

	
	@Override
	public Gson getGson() {
		return Util.getGsonBuilder().create();
	}

	@Override
	public File getDataFolder() {
		return null;
	}
	
	public static class TestConfig extends Config<TestConfig> {
		public boolean test = true;
	}
	
	public static class TestConfigCollection extends ConfigCollection<TestConfig> {

		public TestConfigCollection(MStoreUser user) {
			super("testconfig", TestConfig.class, user);
		}
		
	}
	
	public static void main(String[] args) {
		
		ConfigStoreTest test = new ConfigStoreTest();
		
		TestConfigCollection collection = new TestConfigCollection(test);
		collection.init();
		MStore.collTick();
		TestConfig config = collection.create();
		MStore.collTick();
		System.out.println(config.test);
		MStore.collTick();
	}

}
