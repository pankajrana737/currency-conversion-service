package com.pankaj.rana.microservice.currencyconversionservice.bean;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//name = service name Spring.application.name
//url of service
//feign is rest service client
//hard code url to resolve this use ribbon load balancer
// comment this @FeignClient(name = "currency-exchange-service",url = "localhost:8000")
// adding @RibbonClient(name = "-service name")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
 public	CurrencyConversionBean reteriveExchangeValue(@PathVariable("from") String from, @ PathVariable("to") String to) ;
}
