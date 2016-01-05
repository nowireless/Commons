package org.nowireless.common.util;

public class TimerDelta {
	
	private long last = 0;
	
	public void reset() {
		last = System.currentTimeMillis();
	}
	
	public double delta() {
		return System.currentTimeMillis() - last;
	}
}