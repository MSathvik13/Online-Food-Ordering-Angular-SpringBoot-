package com.food.fa;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	Docket configureSwagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/fa/**"))
				.apis(RequestHandlerSelectors.basePackage("com.food.fa"))
				.build()
				.apiInfo(new ApiInfo("Users API",
						"Our Food API",
						"1.0",
						"We are ready to work for you",
						new Contact("Food", "www.foodapi.com", "food@usersapi.com"),
						"Standard API License",
						"www.usersapi.com",
						Collections.emptyList()
						));

}

}
