package org.nowireless.configstore.mstore;

import org.nowireless.configstore.Config;
import org.nowireless.mstore.MStore;
import org.nowireless.mstore.MStoreUser;
import org.nowireless.mstore.store.Coll;

public abstract class ConfigCollection<T extends Config> extends Coll<T> {
	public ConfigCollection(String basename,Class<T> clazz, MStoreUser user) {
		super(basename, clazz, MStore.getDb(), user);
	}
	
	@Override
	public void onTick()
	{
		super.onTick();
	}
	
}
