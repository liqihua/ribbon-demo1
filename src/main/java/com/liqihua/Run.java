package com.liqihua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Run {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
	
	
	@Bean
	@LoadBalanced//启用负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
}
