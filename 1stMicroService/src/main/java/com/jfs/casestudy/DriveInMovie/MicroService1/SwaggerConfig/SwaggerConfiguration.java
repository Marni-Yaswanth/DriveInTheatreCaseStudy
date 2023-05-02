package com.jfs.casestudy.DriveInMovie.MicroService1.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration{
	
	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI().info(new Info()
				.title("Movie Catalogue Microservice")
				.version("1.0V")
				.description("Movie Catalogue (microservice) Add movie details ▪ Movie Title ▪ Movie Description ▪ Movie Genre ▪ Movie IMDB rating Update Movie Details by Title Search Movie Details by Title Delete Movie Details by Title View All Movie Titles")
				.termsOfService("http://swagger.io/terms/"));
	}
	
}
