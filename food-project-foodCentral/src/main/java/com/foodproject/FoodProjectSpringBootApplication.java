package com.foodproject;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FoodProjectSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodProjectSpringBootApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean 
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.foodproject"))
				.build()
				.apiInfo(new ApiInfo("Food Central's API",
							    "Our API for Testing",
							    "1.0",
							    "Yummy food, within reach.",
							    new Contact("D@rk_Army","www.info@foodcentral.com","mssathvikmurthy98@gmail.com"),								    
							    "Standard Food Delivery License",
							    "www.foodcentral.com",
							    Collections.emptyList()
						));
		}
}
