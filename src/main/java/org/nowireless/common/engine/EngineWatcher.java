package org.nowireless.common.engine;

import org.nowireless.common.LoggerProvider;

/**
 * The Engine watcher is used to detect if a {@link Engine} thread has become locked.
 * It allows a actions to be taken if such a event occurs.
 * 
 * @author nowireless
 *
 */
public interface EngineWatcher extends Engine, LoggerProvider {
	
	/**
	 * Tells the watcher the watched engine checked in.
	 */
	public void checkIn();
	
	/**
	 * Gets the last checkin
	 * @return The time stamp of the last check in
	 */
	public long lastCheckInTimeStamp();
	
	/**
	 * Is called when the Engine is overdue in checking in.
	 */
	public void overDue();
	
	/**
	 * Gets the engine being watched
	 * @return The Engine under watch
	 */
	public Engine getWatchedEngine();
	
	/**
	 * Gets the engine name being watched
	 * @return The Engine name
	 */
	public String getEngineName();
	
	/**
	 * Checks to see if the watched {@link Engine} is locked up.
	 * @return whether the engine is locked up
	 */
	public boolean isLocked();
	
	/**
	 * Enables the watcher
	 */
	public void enable();
	
	/**
	 * Disables the watcher
	 */
	public void disable();
	
	/**
	 * Whether the watcher is enabled
	 * @return enabled state
	 */
	public boolean isEnabled();
}
