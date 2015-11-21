package org.nowireless.configstore.exception;

import org.nowireless.configstore.ConfigException;

public class SaveConfigException extends ConfigException {
	
	private static final long serialVersionUID = -2081245573923398234L;

	public SaveConfigException(String message) {
		super(message);
	}
	
	public SaveConfigException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SaveConfigException(Throwable cause) {
		super(cause);
	}
}
