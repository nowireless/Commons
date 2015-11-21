package org.nowireless.configstore;


public class ConfigException extends Exception {

	private static final long serialVersionUID = -4169656152232890819L;

	public ConfigException(String message) {
		super(message);
	}
	
	public ConfigException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ConfigException(Throwable cause) {
		super(cause);
	}
	
}
