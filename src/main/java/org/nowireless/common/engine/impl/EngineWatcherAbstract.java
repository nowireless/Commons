package org.nowireless.common.engine.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nowireless.common.engine.Engine;
import org.nowireless.common.engine.EngineWatcher;

/**
 * The EngineWatcherAbstract is a {@link EngineAbstract} that watches other {@link Engine}'s
 * @author nowireless
 *
 */
public abstract class EngineWatcherAbstract extends EngineAbstract implements EngineWatcher {

	private transient volatile long lastCheckIn = 0;
	private transient volatile long delta = 0;
	private transient volatile boolean isLocked = false;
	private transient volatile boolean isEnabled = true;
	private transient long timeOut;
	private transient long sleep;
	private transient Logger log;
	private transient Engine engine;
	
	public EngineWatcherAbstract(long timeout, long sleep, Engine engine) {
		this.setUp(timeout, sleep, engine);
	}
	
	public EngineWatcherAbstract(long timeout, long sleep, Engine engine, String threadName) {
		super(threadName);
		this.setUp(timeout, sleep, engine);
	}
	
	private void setUp(long timeout, long sleep, Engine engine) {
		this.timeOut = timeout;
		this.sleep = sleep;
		this.engine = engine;
		log = LogManager.getLogger(this.getEngineName());
		this.enable();
	}
	
	@Override public abstract void overDue();
	@Override public abstract void init();
	@Override public abstract void deinit();
	
	@Override 
	public String getEngineName() {
		return this.getWatchedEngine().getEngineName() + "-Watcher";
	}
	
	@Override
	protected final long getSleepTime() {
		return sleep;
	}
	
	@Override
	public final Logger log() {
		return log;
	}
	
	@Override
	public Engine getWatchedEngine() {
		return engine;
	}
	
	@Override
	public void startEngine() {
		this.checkIn();
		this.isLocked = false;
		super.startEngine();
	}
	
	@Override
	public final void checkIn() {
		this.lastCheckIn = System.currentTimeMillis();
	}

	@Override
	public final long lastCheckInTimeStamp() {
		return this.lastCheckIn;
	}
	
	@Override
	public boolean isLocked() {
		return isLocked;
	}
	
	@Override
	public void enable() {
		log.trace("Enabled");
		this.isEnabled = true;
		lastCheckIn = System.currentTimeMillis();
	}
	
	@Override
	public void disable() {
		log.trace("Disabled");
		this.isEnabled = false;
	}
	
	@Override
	public boolean isEnabled() {
		return this.isEnabled;

	}
	
	@Override
	public final void runTask() {
		delta = System.currentTimeMillis() - lastCheckIn;
		
		if(isEnabled && delta > timeOut) {
			log.warn("Engine: {} is {} mS overdue", engine.getEngineName(), delta);
			this.isLocked = true;
			this.overDue();
		} else {
			this.isLocked = false;
		}
	}

}
