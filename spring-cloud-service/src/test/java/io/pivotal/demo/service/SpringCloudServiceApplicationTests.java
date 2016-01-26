package io.pivotal.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import io.pivotal.demo.service.SpringCloudServiceApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringCloudServiceApplication.class)
@WebAppConfiguration
public class SpringCloudServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
