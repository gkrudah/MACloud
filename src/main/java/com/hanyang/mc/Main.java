package com.hanyang.mc;

import com.hanyang.mc.util.FileListGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String...args) {

		if(args.length == 0) {
			System.out.println("Usage : macloud (down | up) {file | directory}*");
			System.exit(0);
		} else if(args.length == 1) {
			System.out.println("Usage : macloud (down | up) {file | directory}*");
			System.exit(0);
		} else {
			if(args[1].compareToIgnoreCase("down") == 0) {
				/* downloads */

			} else if(args[1].compareToIgnoreCase("up") == 0) {
				/* uploads */

			} else {
				System.out.println("Usage : macloud (down | up) {file | directory}*");
				System.exit(0);
			}
		}

		List<File> files = FileListGetter.get(args);

		System.exit(0);
	}
}
