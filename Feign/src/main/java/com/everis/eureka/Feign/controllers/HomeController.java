package com.everis.eureka.Feign.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.eureka.Feign.clients.RestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class HomeController {

	final RestClient restClient;
	
	@Autowired
	public HomeController(RestClient restClient) {
		this.restClient = restClient;
	}
	
	@GetMapping("/rest-version")
	@HystrixCommand(fallbackMethod = "fallback_list", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
			})
	public List<Object> getList() throws InterruptedException{
		Thread.sleep(800);
		return restClient.getList();
	}
	
	public List<Object> fallback_list() {
		List<Object> error = new ArrayList<Object>();
		error.add("asdas");
		return error;
	}
	
}
