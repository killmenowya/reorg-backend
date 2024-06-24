package com.reorg.grade_overview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GradeOverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeOverviewApplication.class, args);
	}

}
