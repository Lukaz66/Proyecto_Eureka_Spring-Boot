package com.everis.eureka.Feign.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("rest-app")
public interface RestClient {

	@RequestMapping("/api/V1.0/students")
	List<Object> getList();
	
}
