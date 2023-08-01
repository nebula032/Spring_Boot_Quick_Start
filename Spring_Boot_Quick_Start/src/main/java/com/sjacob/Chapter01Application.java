package com.sjacob;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) {
//		SpringApplication.run(Chapter01Application.class, args);
		/*
		 * WebApplicationType
		 * 1. NONE : 자바 애플리케이션 실행
		 * 2. SERVLET : 스프링 MVC 기반 웹 어플리케이션 실행
		 * 3. REACTIVE : 비동기 처리와 논 블로킬 입풀력을 지원하는 웹플럭스 적용
		 * src/main/resources/application.properties 에서 설정 가능
		 */
		SpringApplication application = new SpringApplication(Chapter01Application.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
		
		// 배너 OFF
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
