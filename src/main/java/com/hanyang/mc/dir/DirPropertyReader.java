package com.hanyang.mc.dir;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DirPropertyReader {
	private static final Logger logger = LoggerFactory.getLogger(DirPropertyReader.class);
	private static final String PROPERTY_FILE_NAME = ".mac.properties";
	private static Properties property = new Properties();
	private static File propertyFile;

	/* path is abs path of directory */
	public static boolean readProperties(String path) {

		File file = new File(path);
		if(file.isDirectory()) {
			propertyFile = new File(path + "/" + PROPERTY_FILE_NAME);
			try {
				property.load(new FileInputStream(path + "/" + PROPERTY_FILE_NAME));
				return true;
			} catch (IOException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isUploadNeeded(String fileName) {
		if(property.getProperty(fileName) != null) {
			return true;
		}return false;
	}

	public static void writeProperties(String str) {
		/* String has already checked. so, does not check duplicated file. */
		try {
			FileUtils.write(propertyFile, str, "utf-8", true);
		} catch  (IOException e) {
			logger.error("Failed to write properties below  ....\n {}", str);
		}
	}
}
