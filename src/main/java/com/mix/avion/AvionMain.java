package com.mix.avion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mix.avion.controller")
public class AvionMain {

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
		SpringApplication.run(AvionMain.class, args);
	}

}
