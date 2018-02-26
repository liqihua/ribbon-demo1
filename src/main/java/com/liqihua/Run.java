package com.liqihua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrix//启用断路器
@SpringBootApplication
@EnableDiscoveryClient
public class Run {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
	
	
	@Bean
	@LoadBalanced//启用ribbon负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
}
