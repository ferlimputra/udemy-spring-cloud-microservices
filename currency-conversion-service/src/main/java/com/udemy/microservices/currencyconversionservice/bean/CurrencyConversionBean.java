package com.udemy.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * CurrencyConversionBean
 */
public class CurrencyConversionBean {

  private UUID id;
  private String source;
  private String target;
  private BigDecimal conversionFactor;
  private BigDecimal amount;
  private BigDecimal convertedAmount;
  private int port;

  public CurrencyConversionBean() {
    super();
  }

  public CurrencyConversionBean(String source, String target, BigDecimal conversionFactor,
      BigDecimal amount, BigDecimal convertedAmount, int port) {
    this.id = UUID.randomUUID();
    this.source = source;
    this.target = target;
    this.conversionFactor = conversionFactor;
    this.amount = amount;
    this.convertedAmount = convertedAmount;
    this.port = port;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public BigDecimal getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(BigDecimal conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getConvertedAmount() {
    return convertedAmount;
  }

  public void setConvertedAmount(BigDecimal convertedAmount) {
    this.convertedAmount = convertedAmount;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}
