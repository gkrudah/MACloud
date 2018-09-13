package com.hanyang.mc;

import com.hanyang.mc.util.FileListGetter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileListGetterTest {

	private final static Logger logger = LoggerFactory.getLogger(FileListGetterTest.class);
	private final String path = "/home/lee/Pictures";

	private String regex = "(.+)\\.(.+)";
	// ![image](imageURL)
	private String markImage = "(.*)!\\[(.*)\\]\\((.*)\\)";

	private final Pattern pattern = Pattern.compile(regex);
	private final Pattern markPattern = Pattern.compile(markImage);

	@Test
	public void test() {
		List<File> files = FileListGetter.get(path);

		for(File file : files) {
			System.out.print(file.getAbsolutePath() + " ");
		} System.out.println();
	}

	@Test
	public void regexTest() {
		String filename = "asdfasdfasdf/asdfasdgasdfasdf/agasdfasdff/image.png";
		Matcher matcher = pattern.matcher(filename);

		logger.error("{}", regex);

		if(matcher.find()) {
			logger.error("{}", matcher.group(1));
			logger.error("{}", matcher.group(2));
		}

		String image = "![마나](https://ahmonglang) ![마나ㅇㄹ](https://user-images.githubusercontent.com/35682872/45433138-736c2280-b6e6-11e8-91db-264bcc469d4b.png)";
		matcher = markPattern.matcher(image);
		if(matcher.find()) {
			logger.error("{}", matcher.group(1));
			logger.error("{}", matcher.group(2));
			logger.error("{}", matcher.group(3));
		}
	}
}
