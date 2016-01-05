package org.nowireless.configstore;

import org.nowireless.mstore.MStore;
import org.nowireless.mstore.MStoreUser;
import org.nowireless.mstore.store.Coll;

public abstract class ConfigStore<T extends Config<T>> extends Coll<T> {
	
	public static final String INSTANCE = "instance";
	public static final String DEFAULT= "default";
	
	protected ConfigStore(String basename,Class<T> clazz, MStoreUser user) {
		super(basename, clazz, MStore.getDb(), user);
	}
	
	@Override
	public void onTick()
	{
		super.onTick();
	}
	
	@Override
	public void init() {
		super.init();
		
		//this.getDefault();
	}
	
	public T getDefault() {
		T config = this.get(DEFAULT);
		if(config != null) return config;
		
		config = this.create(DEFAULT);
		
		this.setDeault(config);
		
		return config;
	}
	
	//Child class will override this to set the default config
	protected  void setDeault(T config) {};
	
}
