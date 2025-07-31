package com.dreamcatcher.dreamcatcherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author Sakura
 **/
@SpringBootApplication(scanBasePackages = "com.dreamcatcher.dreamcatcherapi")
public class TheDreamcatcherApi {

	public static void main(String[] args) {
		SpringApplication.run(TheDreamcatcherApi.class, args);
	}
}
