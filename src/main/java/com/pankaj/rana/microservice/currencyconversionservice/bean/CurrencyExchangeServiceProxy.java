package com.pankaj.rana.microservice.currencyconversionservice.bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//name = service name Spring.application.name
//url of service
//feign is rest service client
@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
 public	CurrencyConversionBean reteriveExchangeValue(@PathVariable("from") String from, @ PathVariable("to") String to) ;
}
