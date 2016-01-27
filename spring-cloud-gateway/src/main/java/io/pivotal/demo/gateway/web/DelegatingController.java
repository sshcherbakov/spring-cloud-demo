package io.pivotal.demo.gateway.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.demo.domain.MainResponse;

@RefreshScope
@RestController
public class DelegatingController {
	
	@Value("${spring.application.name:none}")
	private String appId;

	@Autowired
	private RestTemplate rest;
	
	@HystrixCommand(fallbackMethod="fallbackInvoke")
	@RequestMapping(value="/invoke", method=RequestMethod.GET)
	public MainResponse invokeService(@RequestParam(value="service", defaultValue="${service.name:red}") String name) {
		
		 URI uri = UriComponentsBuilder.fromUriString("http://{service}/main")
		            .buildAndExpand(name)
		            .toUri();

		return rest.getForObject(uri, MainResponse.class);
		
	}
	
	MainResponse fallbackInvoke(String name) {
		return new MainResponse("error", "error");
	}
	
}
