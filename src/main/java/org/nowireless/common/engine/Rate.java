package org.nowireless.common.engine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nowireless.common.Initializable;

/**
 * Ported the Rate class from ros
 * https://github.com/ros/roscpp_core/blob/indigo-devel/rostime/src/rate.cpp
 * @author Ryan
 *
 */
public class Rate implements Initializable {

	private volatile long start_;
	private final long expected_cycle_time_;
	private final Logger log = LogManager.getLogger("Rate");
	
	public Rate(long rateTime) {
		this.expected_cycle_time_ = rateTime;
	}
	
	//public Rate(double frequency) {
	//	this(Math.round(1000.0 / frequency ));
	//}
	
	@Override
	public void init() {
		start_ = System.currentTimeMillis();
	}
	
	@Override
	public void deinit() {}
	
	public void sleep() throws InterruptedException {
		/*
		long expected_end = start_ + expected_cycle_time_;
		long actual_end = System.currentTimeMillis();
		
		//Detect backward jumps in time
		if(actual_end < start_) {
			expected_end = actual_end + expected_cycle_time_;
		}
		
		//Calculate the time we'll need for sleep
		long sleepTime = expected_end - start_;

		log.info("Start{}, End, {}, Delta {}", start_, expected_end, sleepTime);
		
		//Make sure to reset our start time
		start_ = expected_end;
		
		
		//If we've taken too much time we won't sleep
		if(sleepTime <= 0) {
			// if we've jumped forward in time, or the loop has taken more than a full extra
		    // cycle, reset our cycle
			if(actual_end > expected_end+expected_cycle_time_) {
				start_ = actual_end;
				
			}
			Thread.sleep(0);
			return;
		}
		
		Thread.sleep(sleepTime);
		*/
		Thread.sleep(expected_cycle_time_);
	}
	
}
