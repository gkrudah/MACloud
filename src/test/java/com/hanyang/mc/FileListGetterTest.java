package com.hanyang.mc;

import com.hanyang.mc.util.FileListGetter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class FileListGetterTest {

	private final static Logger logger = LoggerFactory.getLogger(FileListGetterTest.class);
	private final String path = "/home/lee/Pictures";

	@Test
	public void test() {
		List<File> files = FileListGetter.get(path);

		for(File file : files) {
			System.out.print(file.getAbsolutePath() + " ");
		} System.out.println();
	}
}
