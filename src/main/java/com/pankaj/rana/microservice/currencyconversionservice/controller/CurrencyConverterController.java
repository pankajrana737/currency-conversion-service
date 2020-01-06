package com.pankaj.rana.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pankaj.rana.microservice.currencyconversionservice.bean.CurrencyConversionBean;
import com.pankaj.rana.microservice.currencyconversionservice.bean.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConverterController {
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversionBean getCurrencyConversionbean(@PathVariable String from,
		@PathVariable String to,@PathVariable BigDecimal quantity) {
	// lot of code // to reduce this use Feign client (integration with ribbon
	//client side load balancer
	Map<String,String> uriVariableMap= new HashMap<String,String> ();
	uriVariableMap.put("from", from);
	uriVariableMap.put("to", to);
	ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariableMap);
	CurrencyConversionBean currencyBean = responseEntity.getBody();
	return new CurrencyConversionBean(currencyBean.getId(), currencyBean.getFrom(),
			currencyBean.getTo(), currencyBean.getconvertionMultiple(),quantity, currencyBean.getconvertionMultiple().multiply(quantity),currencyBean.getPort());
}
//http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/10
//using feign client method
@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversionBean getCurrencyConversionbeanFeign(@PathVariable String from,
		@PathVariable String to,@PathVariable BigDecimal quantity) {
	// lot of code // to reduce this use Feign client (integration with ribbon
	//client side load balancer
	CurrencyConversionBean currencyBean = currencyExchangeServiceProxy.reteriveExchangeValue(from, to);
	return new CurrencyConversionBean(currencyBean.getId(), currencyBean.getFrom(),
			currencyBean.getTo(), currencyBean.getconvertionMultiple(),quantity, currencyBean.getconvertionMultiple().multiply(quantity),currencyBean.getPort());
}
}
