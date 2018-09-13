package com.hanyang.mc;

import com.hanyang.mc.dir.DirPropertyReader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirPropertyReaderTest {
	private static final Logger logger = LoggerFactory.getLogger(DirPropertyReaderTest.class);
	@Test
	public void test() {
		DirPropertyReader.readProperties("/home/lee/pictures");
		logger.error("{}", DirPropertyReader.isUploadNeeded("Background.jpg"));
		logger.error("{}", DirPropertyReader.isUploadNeeded("Hello.jpg"));
		logger.error("{}", DirPropertyReader.isUploadNeeded("Hello.png"));
		DirPropertyReader.writeProperties("Hello.png=https://");
	}
}
