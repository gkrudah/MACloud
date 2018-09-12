package com.hanyang.mc;

import com.hanyang.mc.util.FileListGetter;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FileListGetterTest {

	private final String path = "D:\\Pictures\\카메라";

	@Test
	public void test() {
		List<File> files = FileListGetter.get(path);

		for(File file : files) {
			System.out.print(file.getAbsolutePath() + " ");
		} System.out.println();
	}
}
