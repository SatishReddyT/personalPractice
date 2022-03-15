package com.bhavna.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class NaukriProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaukriProfileServiceApplication.class, args);
	}

}
