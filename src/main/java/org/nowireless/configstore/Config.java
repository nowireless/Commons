package org.nowireless.configstore;

import java.util.concurrent.locks.ReentrantLock;

import org.nowireless.mstore.store.Entity;

/**
 * A base interface for Configs
 * @author nowireless
 *
 */
public abstract class Config<T extends Config<T>> extends Entity<T> {
	
	private transient final ReentrantLock lock = new ReentrantLock();
	
	public void lockConfig() {
		lock.lock();
	}
	
	public void unlockConfig() {
		lock.unlock();
	}
	
	public boolean isLocked() {
		return lock.isLocked();
	}
}
