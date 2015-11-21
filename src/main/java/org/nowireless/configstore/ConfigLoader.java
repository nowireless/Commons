package org.nowireless.configstore;


import java.io.IOException;

import org.nowireless.common.LoggerProvidor;
import org.nowireless.configstore.exception.LoadConfigException;
import org.nowireless.configstore.exception.SaveConfigException;

/**
 * Helps with loading and saving of configs
 * @author nowireless
 *
 */
public interface ConfigLoader extends LoggerProvidor {
	
	/**
	 * Loads the config for the given class
	 * @param clazz The Config class
	 * @return The config
	 * @throws IOException
	 * @throws InstantiationError
	 * @throws IllegalAccessException
	 */
	public <T extends Config> T loadConfig(Class<T> clazz) throws LoadConfigException;
	
	/**
	 * Saves the given config
	 * @param config The config to save
	 * @throws IOException
	 */
	public void saveConfig(Config config) throws SaveConfigException;
}
