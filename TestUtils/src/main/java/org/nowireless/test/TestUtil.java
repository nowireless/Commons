package org.nowireless.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtil {
	
	public static final String TEST_PATH = "./bin/test/";
	public static final File TEST_PATH_FILE = new File(TEST_PATH);
	
	private static final Logger log = LogManager.getLogger(TestUtil.class.getSimpleName());
	
	public static String CURRENT_TEST = "unknown/";
	
	/**
	 * Sets the name of the current test based on the simple name of the provided class
	 * @param clazz The test class
	 */
	public static void setCurrentTest(Class<?> clazz) {
		setCurrentTest(clazz.getSimpleName());
	}
	
	/**
	 * Set the name of the current test
	 * @param test The name of the test
	 */
	public static void setCurrentTest(String test) {
		CURRENT_TEST = test;
		log.info("Setting current test to {}", getCurrentTestPath());
	}
	
	/**
	 * Gets the path for the current test
	 * @return The test path
	 */
	public static String getCurrentTestPath() {
		return TEST_PATH + CURRENT_TEST + "/";
	}
	
	/**
	 * Gets the path of for the current test as a file.
	 * @return The test path file
	 */
	public static File getCurrentTestPathFile() {
		return new File(TEST_PATH_FILE, CURRENT_TEST);
	}

	/**
	 * Cleans the given Directory
	 * @param path The path to clean
	 */
	public static void cleanDirectory(String path) {
		Validate.notNull(path);
		cleanDirectory(new File(path));
	}
	
	/**
	 * Cleans the given Directory
	 * @param parent The parent directory
	 * @param dir The Path within the parent
	 */
	public static void cleanDirectory(File parent, String dir) {
		Validate.notNull(parent);
		Validate.notNull(dir);
		cleanDirectory(new File(parent, dir));
	}
	
	/**
	 * Cleans the given Directory
	 * @param file The directory to be cleaned
	 */
	public static void cleanDirectory(File file) {
		Validate.notNull(file);
		try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			log.fatal("Could not clean Diectory {}", file.getAbsolutePath());
		}
	}
}
