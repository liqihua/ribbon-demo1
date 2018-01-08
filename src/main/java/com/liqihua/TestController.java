package com.liqihua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	@Autowired
    RestTemplate restTemplate;
	
	
	@RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
		String result =  restTemplate.getForObject("http://eureka-client-demo1/hi?name="+name, String.class);
		System.out.println("--- ribbon : result : "+result);
        return result;
    }
}
