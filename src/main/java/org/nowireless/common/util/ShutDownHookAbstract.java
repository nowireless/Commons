package org.nowireless.common.util;

public abstract class ShutDownHookAbstract extends Thread implements ShutDownHook {

	protected volatile boolean registered = false;

	@Override
	public void register() {
		if(this.registered) return;
		Runtime.getRuntime().addShutdownHook(this);
		this.registered = true;
	}

	@Override
	public void unRegister() {
		if (!this.registered) return;
		Runtime.getRuntime().removeShutdownHook(this);
		this.registered = false;
	}

	@Override
	public abstract void run();
}
