package com.mix.voiturev5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = "com.mix.voiturev5.controller")
public class Voiturev5 {

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("*").allowedOrigins("http://localhost").allowedMethods("*").allowedHeaders("*");
////				registry.addMapping("*").allowedOrigins("http://localhost:8080").allowedMethods("*").allowedHeaders("*");
//			}
//		};
//		return webMvcConfigurer;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Voiturev5.class, args);
	}

}
