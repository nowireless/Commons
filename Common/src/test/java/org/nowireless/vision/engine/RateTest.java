package org.nowireless.vision.engine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nowireless.common.engine.Rate;

public class RateTest {
	public static void main(String[] args) throws InterruptedException {
		
		Logger log = LogManager.getLogger();
		Rate rate = new Rate(50);
		
		log.info("{}", System.currentTimeMillis());
		rate.init();
		rate.sleep();
		
		log.info("{}", System.currentTimeMillis());
		rate.sleep();
		log.info("{}", System.currentTimeMillis());
		
		Thread.sleep(13);
		rate.sleep();
		log.info("{}", System.currentTimeMillis());
		rate.sleep();
	}
}
