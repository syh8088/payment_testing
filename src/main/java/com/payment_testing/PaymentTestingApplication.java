package com.payment_testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PaymentTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentTestingApplication.class, args);
	}

}
