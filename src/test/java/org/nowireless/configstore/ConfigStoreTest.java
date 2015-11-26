package org.nowireless.configstore;

import java.util.List;

import org.nowireless.common.util.Utilities;
import org.nowireless.mstore.MStore;
import org.nowireless.mstore.MStoreUser;

import com.google.gson.Gson;

public class ConfigStoreTest implements MStoreUser {

	
	@Override
	public Gson getGson() {
		return Utilities.getGsonBuilder().create();
	}
	
	public static class TestConfig extends Config<TestConfig> {
		public boolean test = true;
		List<String> list;
	}
	
	public static class TestConfigCollection extends ConfigStore<TestConfig> {

		public TestConfigCollection(MStoreUser user) {
			super("testconfig", TestConfig.class, user);
		}
		
	}
	
	public static void main(String[] args) {
		
		ConfigStoreTest test = new ConfigStoreTest();
		
		TestConfigCollection collection = new TestConfigCollection(test);
		collection.init();
		MStore.collTick();
		TestConfig config = collection.get("The Config");
		config.test = false;
		
		//config.list = new ArrayList<>();
		//config.list.add("Test!");
		
		if(config.list != null) System.out.println(config.list);
		
		config.changed();
		MStore.collTick();
		System.out.println(config.test);
		MStore.collTick();
	}

}
