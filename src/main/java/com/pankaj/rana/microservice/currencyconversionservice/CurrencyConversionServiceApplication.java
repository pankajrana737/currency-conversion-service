package com.pankaj.rana.microservice.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
//enable feign scan packages
@EnableFeignClients(value = {"com.pankaj.rana.microservice.currencyconversionservice"})
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	//adding sleuth debuging fro all request 
	  @Bean
	  public Sampler defaultSampler() {
	    return  Sampler.ALWAYS_SAMPLE;
	  }

}
