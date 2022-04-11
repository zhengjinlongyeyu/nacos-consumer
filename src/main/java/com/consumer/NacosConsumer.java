package com.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.OpenFeignClientServie;



@RestController
public class NacosConsumer {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TsetOpenfeigen tsetOpenfeigen;
	

	
	@RequestMapping("/getOrder")
	public Object name() {
		List<ServiceInstance> instances = discoveryClient.getInstances("nacostest");
		ServiceInstance serviceInstance = instances.get(0);
		String forObject = restTemplate.getForObject(serviceInstance.getUri()+"/getname", String.class);
		return forObject;
	}
	
	@RequestMapping("/getMessage")
	public Object getMessage() {
		
		String message = tsetOpenfeigen.getMessage();
		return message;
	}
	
	@RequestMapping("/getest")
	public Object getest() {
		
		String message = tsetOpenfeigen.gettest();
		return message;
	}
	
	@RequestMapping("/getlong")
	public Object getlong(String aaaa) {
		
		String message = tsetOpenfeigen.getlong(aaaa);
		return message;
	}
	
	@RequestMapping("/member")
	public String  member() {
		
		
		return "member8082";
	}

}
