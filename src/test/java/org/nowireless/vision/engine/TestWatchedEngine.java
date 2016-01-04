package org.nowireless.vision.engine;

import org.nowireless.common.engine.impl.WatchedEngineAbstact;

public class TestWatchedEngine extends WatchedEngineAbstact {

	public TestWatchedEngine(long timeout) {
		super(timeout, "TestWatchedEngine");
	}

	@Override
	public void init() {
		log().info("Init");
		
	}

	@Override
	public void deinit() {
		log().info("DeInit");
	}

	@Override
	protected long getSleepTime() {
		return 10;
	}

	@Override
	public void runTask() {
		log().info("Runnning Task!");
	}

	@Override
	protected void overdue() {
		// TODO Auto-generated method stub
		
	}

}
