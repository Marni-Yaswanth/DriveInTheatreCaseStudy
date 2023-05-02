package com.microservices.CaseStudy.DriveInMovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DriveInMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriveInMovieApplication.class, args);
	}

}
