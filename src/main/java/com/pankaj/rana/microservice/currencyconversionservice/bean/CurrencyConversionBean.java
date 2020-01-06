package com.pankaj.rana.microservice.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	 private long id;
	 private String from;
	 private String to;
	 private BigDecimal convertionMultiple;
	 private BigDecimal quantity;
	 private BigDecimal totalCalculatedAmount; 
	 private int port;
	 
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public long getId() {
		return id;
	}
	public CurrencyConversionBean(long id, String from, String to, BigDecimal convertionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getconvertionMultiple() {
		return convertionMultiple;
	}
	public void setconvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public CurrencyConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversionBean(long id, String from, String to, BigDecimal convertionMultiple, BigDecimal quantity) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
		this.quantity = quantity;
	}

	 
}
