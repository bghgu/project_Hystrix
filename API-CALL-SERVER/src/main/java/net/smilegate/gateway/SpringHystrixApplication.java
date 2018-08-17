package net.smilegate.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 
 * @author dsbae
 *
 */

@SpringBootApplication
//Hystrix 사용
@EnableHystrix
//Circuit Breaker 활성화
@EnableCircuitBreaker
//DashBoard 활성화
//application.properties의 설정 파일 활성화 필요
@EnableHystrixDashboard
public class SpringHystrixApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(SpringHystrixApplication.class);
	}
	
	public static void main(final String[] args) {
		SpringApplication.run(SpringHystrixApplication.class, args);
	}
}
