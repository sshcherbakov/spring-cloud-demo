package io.pivotal.demo.service.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.demo.domain.MainResponse;

@RefreshScope
@RestController
public class MainController {
	
	@Value("${spring.application.name:none}")
	private String appId;

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public MainResponse mainService(@RequestParam(value="name", defaultValue="${echo.name:world}") String param) {
		return new MainResponse(param, appId);
	}
	
}
