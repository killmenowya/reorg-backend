package com.reorg.user_setting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserSettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSettingApplication.class, args);
	}

}