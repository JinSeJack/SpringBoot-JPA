package com.ibike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBootApplication标签可以自动扫描所在包以及子包下的文件
 */
@SpringBootApplication
public class GovernApplication {

	public static void main(String[] args) {
		SpringApplication.run(GovernApplication.class, args);
	}
}
