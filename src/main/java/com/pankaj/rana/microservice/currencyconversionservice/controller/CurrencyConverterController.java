package com.pankaj.rana.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pankaj.rana.microservice.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConverterController {
@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversionBean getCurrencyConversionbean(@PathVariable String from,
		@PathVariable String to,@PathVariable BigDecimal quantity) {
	Map<String,String> uriVariableMap= new HashMap<String,String> ();
	uriVariableMap.put("from", from);
	uriVariableMap.put("to", to);
	ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariableMap);
	CurrencyConversionBean currencyBean = responseEntity.getBody();
	return new CurrencyConversionBean(currencyBean.getId(), currencyBean.getFrom(),
			currencyBean.getTo(), currencyBean.getconvertionMultiple(),quantity, currencyBean.getconvertionMultiple().multiply(quantity),currencyBean.getPort());
}
}
