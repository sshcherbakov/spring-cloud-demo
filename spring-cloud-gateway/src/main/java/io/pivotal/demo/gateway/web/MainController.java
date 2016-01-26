package io.pivotal.demo.gateway.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.pivotal.demo.domain.MainResponse;

@RestController
public class MainController {
	
	@Value("${spring.application.name:none}")
	private String appId;
	
	@Autowired
	private RestTemplate rest;

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public MainResponse mainService() {
		
		 URI uri = UriComponentsBuilder.fromUriString("http://red/main")
		            .build()
		            .toUri();

		MainResponse response = rest.getForObject(uri, MainResponse.class);
		
		return response;
	}
	
}
