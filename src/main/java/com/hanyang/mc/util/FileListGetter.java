package com.hanyang.mc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileListGetter {
	private static Logger logger = LoggerFactory.getLogger(FileListGetter.class);
	private static Pattern pattern = Pattern.compile("(.+)\\.(.+)");
	private static Matcher matcher;

	public static List<File> get(String path) {
		File file = new File(path);
		List<File> retResult = new ArrayList<>();
		String tmp;

		if(file.isDirectory()) {
			/* Get all file list of directory */
			File[] fileArray = file.listFiles();
			if(fileArray == null) {
				return Collections.emptyList();
			}
			for(File f : fileArray) {
				if(f.isDirectory()) {
					retResult.addAll(get(f.getAbsolutePath()));
				} else {
					matcher = pattern.matcher(f.getAbsolutePath());
					if(matcher.find()) {
						tmp = matcher.group(2);
						if(tmp.compareToIgnoreCase("jpg") == 0 ||
							tmp.compareToIgnoreCase("png") == 0 ||
							tmp.compareToIgnoreCase("gif") == 0 ||
							tmp.compareToIgnoreCase("txt") == 0 ||
							tmp.compareToIgnoreCase("zip") == 0)
						retResult.add(f);
					}
				}
			}
		} else {
			matcher = pattern.matcher(file.getAbsolutePath());
			if(matcher.find()) {
				tmp = matcher.group(2);
				if(tmp.compareToIgnoreCase("jpg") == 0 ||
						tmp.compareToIgnoreCase("png") == 0 ||
						tmp.compareToIgnoreCase("gif") == 0 ||
						tmp.compareToIgnoreCase("txt") == 0 ||
						tmp.compareToIgnoreCase("zip") == 0)
					retResult.add(file);
			}
		}

		return retResult;
	}

	public static List<File> get(String[] paths) {
		List<File> retResult = new ArrayList<>();

		for(String path : paths) {
			retResult.addAll(get(path));
			if(retResult.size() > 10000) {
				logger.error("Failed to read images : Too many files..");
			}
		}

		return retResult;
	}
}
