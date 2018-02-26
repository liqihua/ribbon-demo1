package com.liqihua;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	@Autowired
    RestTemplate restTemplate;

    /**
     * Hystrix能够使得当调用的服务崩溃或不可用时，调用fallbackMethod指定的方法
     */
    @HystrixCommand(fallbackMethod = "hiError")
	@RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
		String result =  restTemplate.getForObject("http://eureka-client-demo1/hi?name="+name, String.class);
		System.out.println("--- ribbon : result : "+result);
        return result;
    }

    /**
     * 返回服务调用失败信息
     * @param name
     * @return
     */
    public String hiError(String name){
        return name+",service hi is error!";
    }


}
