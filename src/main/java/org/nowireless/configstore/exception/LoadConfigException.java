package org.nowireless.configstore.exception;

import org.nowireless.configstore.ConfigException;

public class LoadConfigException extends ConfigException {

	private static final long serialVersionUID = -6125207975218003513L;

	public LoadConfigException(String message) {
		super(message);
	}
	
	public LoadConfigException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public LoadConfigException(Throwable cause) {
		super(cause);
	}
}
